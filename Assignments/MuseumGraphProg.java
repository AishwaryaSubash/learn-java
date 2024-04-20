class Exhibit {
    private String name;
    private int id;

    public Exhibit(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Exhibit: " + name + " (ID: " + id + ")";
    }
}

class MuseumGraph {
    private int[][] adjacencyMatrix;
    private Exhibit[] exhibits;

    public MuseumGraph(int numExhibits) {
        adjacencyMatrix = new int[numExhibits][numExhibits];
        exhibits = new Exhibit[numExhibits];
    }

    public void addExhibit(Exhibit exhibit, int index) {
        exhibits[index] = exhibit;
    }

    public void connectExhibits(int fromIndex, int toIndex, int distance) {
        adjacencyMatrix[fromIndex][toIndex] = distance;
        adjacencyMatrix[toIndex][fromIndex] = distance;
    }

    public int getDistance(int fromIndex, int toIndex) {
        return adjacencyMatrix[fromIndex][toIndex];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Museum Layout:\n");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            sb.append(exhibits[i]).append(" connected to:\n");
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    sb.append("  - ").append(exhibits[j]).append(" (Distance: ").append(adjacencyMatrix[i][j])
                            .append(")\n");
                }
            }
        }
        return sb.toString();
    }
}

public class MuseumGraphProg {
    public static void main(String[] args) {
        Exhibit[] artExhibits = {
                new Exhibit("Monet's Water Lilies", 1),
                new Exhibit("Michelangelo's Pieta", 2),
                new Exhibit("Egyptian Sarcophagi", 3),
                new Exhibit("Picasso's Guernica", 4),
                new Exhibit("Van Gogh's Sunflowers", 5)
        };
        MuseumGraph museumGraph = new MuseumGraph(5);
        for (int i = 0; i < artExhibits.length; i++) {
            museumGraph.addExhibit(artExhibits[i], i);
        }
        for (int i = 0; i < artExhibits.length; i++) {
            for (int j = i + 1; j < artExhibits.length; j++) {
                museumGraph.connectExhibits(i, j, 1); // Default distance of 1
            }
        }
        System.out.println("Art Museum Layout:\n" + museumGraph);
    }
}
