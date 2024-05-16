import java.util.*;
import java.util.concurrent.Flow.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

class TrendingHashtagsProcessor implements Subscriber<String> {
    private Subscription subscription;
    private Map<String, Integer> hashtagCount = new HashMap<>();
    private List<String> topTrendingHashtags = new ArrayList<>();
    private static final int TOP_N = 3;
    private AtomicBoolean completed = new AtomicBoolean(false);
    private CountDownLatch latch;

    public TrendingHashtagsProcessor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(String hashtag) {
        hashtagCount.put(hashtag, hashtagCount.getOrDefault(hashtag, 0) + 1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        latch.countDown();
    }

    @Override
    public void onComplete() {
        completed.set(true);
        calculateTopTrendingHashtags();
        latch.countDown();
    }

    private void calculateTopTrendingHashtags() {
        topTrendingHashtags = hashtagCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(TOP_N)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getTopTrendingHashtags() {
        return topTrendingHashtags;
    }

    public boolean isCompleted() {
        return completed.get();
    }
}

class TrendingHashtagsPublisher extends SubmissionPublisher<String> {
    public void publishHashtag(String hashtag) {
        submit(hashtag);
    }

    public void complete() {
        close();
    }
}

public class Hash {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        TrendingHashtagsPublisher hashtagsPublisher = new TrendingHashtagsPublisher();
        TrendingHashtagsProcessor hashtagsProcessor = new TrendingHashtagsProcessor(latch);
        hashtagsPublisher.subscribe(hashtagsProcessor);
        hashtagsPublisher.publishHashtag("#Java");
        hashtagsPublisher.publishHashtag("#ReactiveProgramming");
        hashtagsPublisher.publishHashtag("#Java9");
        hashtagsPublisher.publishHashtag("#Concurrency");
        hashtagsPublisher.complete();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Top Trending Hashtags: " + hashtagsProcessor.getTopTrendingHashtags());
    }
}
