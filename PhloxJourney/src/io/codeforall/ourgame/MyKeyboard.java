package io.codeforall.ourgame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

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

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key1 = keyboardEvent.getKey();
        if (key1 == 32) {
            if (phlox.isCrash()){
                return;
            }
            phlox.jump();
        }

        int key2 = keyboardEvent.getKey();
        if (key2 == 32) {
            g.isStarted = true;
        }

        int key3 = keyboardEvent.getKey();
        if (key3 == 10) {
            if (!g.ok){
                return;
            }
            g.restart = true;
        }
    }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
        }
    }

