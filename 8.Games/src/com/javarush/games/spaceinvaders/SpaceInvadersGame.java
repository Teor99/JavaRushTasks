package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public static final int COMPLEXITY = 5;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createStars() {
        stars = new ArrayList<>();
        stars.add(new Star(0,0));
        stars.add(new Star(0,1));
        stars.add(new Star(0,2));
        stars.add(new Star(0,3));
        stars.add(new Star(1,0));
        stars.add(new Star(1,1));
        stars.add(new Star(1,2));
        stars.add(new Star(1,3));
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        drawScene();
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }

        stars.forEach(star -> star.draw(this));
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
    }
}
