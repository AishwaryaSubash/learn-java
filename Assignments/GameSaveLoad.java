import java.io.*;
import java.util.*;

public class GameSaveLoad {
    public static void main(String[] args) {
        int currentLevel = 5;
        List<String> achievements = new ArrayList<>(Arrays.asList("First Level Completed", "Master Explorer"));
        Map<String, Integer> playerInventory = new HashMap<>();
        playerInventory.put("Gold", 1000);
        playerInventory.put("Health Potion", 3);

        GameState gameState = new GameState(currentLevel, achievements, playerInventory);
        saveGameState(gameState, "savegame.dat");
        GameState loadedGameState = loadGameState("savegame.dat");
        if (loadedGameState != null) {
            System.out.println("Loaded Game State: " + loadedGameState);
        } else {
            System.out.println("Failed to load game state.");
        }
    }

    private static void saveGameState(GameState gameState, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(gameState);
            System.out.println("Game state saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static GameState loadGameState(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (GameState) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
