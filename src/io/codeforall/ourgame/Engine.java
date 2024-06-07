package io.codeforall.ourgame;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.io.IOException;

public class Engine {

    private Bird phlox;
    private Pipe pipe;
    protected MyKeyboard keyboard;
    private CollisionDetector collision;
    private Score score;
    private int frameCounter;
    protected boolean isStarted;
    protected boolean restart;
    protected boolean ok;

    public Engine() {
        Canvas.limitCanvasHeight(700);
        Canvas.limitCanvasWidth(500);
        SoundManager sound = new SoundManager();
        sound.startBackgroundMusic();
    }

    public void init() throws InterruptedException {
        Picture background = new Picture(0, -50, "background.png");
        background.draw();
        restart = false;
        ok = false;
        Text showScore;
        Text showHighScore;
        phlox = new Bird();
        pipe = new Pipe();
        score = new Score(pipe, phlox);
        new HighScoreManager(score);
        Floor floor = new Floor();
        keyboard = new MyKeyboard(phlox, this);
        collision = new CollisionDetector(phlox, pipe);
        while (true) {
            Thread.sleep(5);
            floor.moveFloor();
            floor.createFloor();
            frameCounter++;
            phlox.redraw(frameCounter);
            if (frameCounter == 50) {
                frameCounter = 9;
            }
            if (isStarted) {
                start();
            }
            if (phlox.isCrash()) {
                isStarted = false;
                showHighScore = new Text(220, 150, score.toString(Score.highScore));
                showScore = new Text(247.5, 100, score.toString((Integer) score.score));
                showHighScore.grow(100, 30);
                showScore.grow(80, 30);
                showScore.draw();
                showHighScore.draw();
                score.delete();
                break;
            }
        }
        while (!restart) {
            ok = true;
            System.out.print("");
            if (restart) {
                phlox.delete();
                floor.delete();
                pipe.delete();
                showHighScore.delete();
                showScore.delete();
                background.delete();
                break;
                }
            }
        init();
    }

    private void start() {
        score.scoreKeeper();
        pipe.movePipe();
        pipe.createPipe();
        phlox.gravity();
        collision.check();
    }

    public void quit() throws IOException {

        int choice = JOptionPane.showConfirmDialog(null, "Do you want to leave Phlox alone?", "Quit", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

}


