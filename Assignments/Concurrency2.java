import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Concurrency2 {
    private static final ForkJoinPool pool = new ForkJoinPool();
    private static final List<String> sequentialTimeline = List.of(
            "Event 1: Big Bang",
            "Event 2: Formation of stars and galaxies",
            "Event 3: Birth of the Solar System",
            "Event 4: Evolution of life on Earth",
            "Event 5: Invention of agriculture",
            "Event 6: Industrial Revolution",
            "Event 7: First human on the Moon",
            "Event 8: Invention of the Internet",
            "Event 9: Modern advancements in technology");
    private static final List<String> parallelTimelines = List.of(
            "Parallel Timeline 1: Exploration of galaxy NGC 1234",
            "Parallel Timeline 2: Discovery of exoplanets in Andromeda galaxy",
            "Parallel Timeline 3: Exploration of the multiverse theory",
            "Parallel Timeline 4: Development of interstellar travel technology",
            "Parallel Timeline 5: First contact with extraterrestrial civilization",
            "Parallel Timeline 6: Colonization of exoplanets by humans",
            "Parallel Timeline 7: Advancements in quantum computing",
            "Parallel Timeline 8: Evolution of artificial intelligence",
            "Parallel Timeline 9: Exploration of parallel dimensions");

    public static void main(String[] args) {
        ExploreSequentialTimelineTask sequentialTask = new ExploreSequentialTimelineTask(sequentialTimeline);
        ExploreParallelTimelinesTask parallelTask = new ExploreParallelTimelinesTask(parallelTimelines);
        pool.invoke(sequentialTask);
        System.out.println();
        pool.invoke(parallelTask);
    }

    private static void exploreSequential(List<String> timeline) {
        System.out.println("Sequential Exploration:");
        timeline.forEach(System.out::println);
    }

    private static void exploreParallel(List<String> timelines) {
        System.out.println("Parallel Exploration:");
        timelines.parallelStream().forEach(System.out::println);
    }

    private static class ExploreSequentialTimelineTask extends RecursiveAction {
        private final List<String> timeline;

        public ExploreSequentialTimelineTask(List<String> timeline) {
            this.timeline = timeline;
        }

        @Override
        protected void compute() {
            exploreSequential(timeline);
        }
    }

    private static class ExploreParallelTimelinesTask extends RecursiveAction {
        private final List<String> timelines;

        public ExploreParallelTimelinesTask(List<String> timelines) {
            this.timelines = timelines;
        }

        @Override
        protected void compute() {
            exploreParallel(timelines);
        }
    }
}
