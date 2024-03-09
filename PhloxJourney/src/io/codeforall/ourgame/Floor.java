package io.codeforall.ourgame;

import org.academiadecodigo.simplegraphics.pictures.*;

public class Floor {
    private Picture floor1;
    private Picture floor2;
    private Picture floor3;

    public Floor() {
        floor1 = new Picture(0, 625,"resources/floor.png");
        floor1.draw();
        floor2 = new Picture(300, 625, "resources/floor.png");
        floor2.draw();
        floor3 = new Picture(600,625,"resources/floor.png");
        floor3.draw();
    }

    public void moveFloor() {
        floor1.translate(-1,0);
        floor2.translate(-1,0);
        floor3.translate(-1,0);
    }

    public void createFloor() {
        if (floor1.getX() == -300) {
            floor1.delete();
            floor1 = new Picture(600, 625, "resources/floor.png");
            floor1.draw();
        }
        if (floor2.getX() == -300) {
            floor2.delete();
            floor2 = new Picture(600, 625, "resources/floor.png");
            floor2.draw();
        }
        if (floor3.getX() == -300) {
            floor3.delete();
            floor3 = new Picture(600, 625, "resources/floor.png");
            floor3.draw();
        }
    }

    public void delete(){
        floor1.delete();
        floor2.delete();
        floor3.delete();
    }
}
