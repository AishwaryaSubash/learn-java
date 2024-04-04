import java.io.*;
import java.util.*;

public class GameState implements Serializable {
    private int currentLevel;
    private List<String> achievements;
    private Map<String, Integer> playerInventory;

    public GameState(int currentLevel, List<String> achievements, Map<String, Integer> playerInventory) {
        this.currentLevel = currentLevel;
        this.achievements = achievements;
        this.playerInventory = playerInventory;
    }

    @Override
    public String toString() {
        return "\n" +
                "Current Level : " + currentLevel + " \n" +
                "Achievements : " + achievements + " \n" +
                "Player Inventory : " + playerInventory;
    }
}
