package io.codeforall.ourgame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class MyKeyboard implements KeyboardHandler {

    private final Keyboard keyboard = new Keyboard(this);
    private final Bird phlox;
    private final Engine g;

    public MyKeyboard(Bird phlox, Engine g) {
        this.phlox = phlox;
        this.g = g;
        addKeyboard();
    }

    public void addKeyboard() {
        KeyboardEvent jump = new KeyboardEvent();
        jump.setKey(KeyboardEvent.KEY_SPACE);
        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(jump);

        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_SPACE);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);

        KeyboardEvent restart = new KeyboardEvent();
        restart.setKey(KeyboardEvent.KEY_ENTER);
        restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(restart);

        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_ESC);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(quit);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        if (key == 32) {
            if (phlox.isCrash()){
                return;
            }
            phlox.jump();
        }

        if (key == 32) {
            g.isStarted = true;
        }

        if (key == 10) {
            if (!g.ok){
                return;
            }
            g.restart = true;
        }

        if (key == 27) {
            try {
                g.quit();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
        }
    }

