package io.codeforall.ourgame;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class BackgroundMusic implements Runnable {

    private Clip backgroundMusic;
    private URL urlmusic;

    public BackgroundMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.urlmusic = this.getClass().getResource("/music.wav");
        this.setURL(this.urlmusic);
    }

    public void setURL(URL soundFileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream sound = AudioSystem.getAudioInputStream(soundFileName);
        this.backgroundMusic = AudioSystem.getClip();
        this.backgroundMusic.open(sound);
        FloatControl gainControl = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-5.0f);
        backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void run() {
        backgroundMusic.start();
        try {
            Thread.sleep(1000000);
        } catch (Exception ignore) {}
    }
}
