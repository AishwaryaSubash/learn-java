import java.util.List;

public class Concurrency {
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

    public static void main(String[] args) {
        exploreSequentially();
    }

    private static void exploreSequentially() {
        System.out.println("Exploring the timeline sequentially:");
        sequentialTimeline.stream()
                .forEach(event -> System.out.println("Event: " + event));
    }
}
