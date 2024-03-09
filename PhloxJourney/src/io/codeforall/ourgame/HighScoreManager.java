package io.codeforall.ourgame;

import java.io.*;
import java.nio.file.*;

public class HighScoreManager {

    private static final String DIRECTORY_NAME = ".ourgame";
    private static final String FILENAME = "highscore.txt";
    private static final Path FILE_PATH;

    static {
        FILE_PATH = Paths.get(System.getProperty("user.home"), DIRECTORY_NAME, FILENAME);
        try {
            Files.createDirectories(FILE_PATH.getParent());
        } catch (IOException e) {
            System.err.println("Error creating directory for high score: " + e.getMessage());
        }
    }
    private Score score;

    public HighScoreManager(Score score){
        this.score = score;
    }

    public static void saveHighScore(int highScore) {
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {
            writer.write(Integer.toString(highScore));
        } catch (IOException e) {
            System.err.println("Error saving high score: " + e.getMessage());
        }
    }

    public static int loadHighScore() {
        try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                Score.highScore = Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading high score: " + e.getMessage());
        }
        return Score.highScore;
    }
}