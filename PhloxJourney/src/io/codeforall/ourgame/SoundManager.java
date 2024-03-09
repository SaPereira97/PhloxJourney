package io.codeforall.ourgame;

public class SoundManager {

    public void startBackgroundMusic() {
        try {
            BackgroundMusic sounds = new BackgroundMusic();
            Thread thread = new Thread(sounds);
            thread.start();
            thread.interrupt();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
