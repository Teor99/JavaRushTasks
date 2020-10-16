package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.UP) {
            isUpPressed = true;
        } else if (key == Key.LEFT) {
            isLeftPressed = true;
            isRightPressed = false;
        } else if (key == Key.RIGHT) {
            isRightPressed = true;
            isLeftPressed = false;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.UP) {
            isUpPressed = false;
        } else if (key == Key.LEFT) {
            isLeftPressed = false;
        } else if (key == Key.RIGHT) {
            isRightPressed = false;
        }
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH / 2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        isLeftPressed = false;
        isRightPressed = false;
        isUpPressed = false;
        createGameObjects();
        drawScene();
        setTurnTimer(50);
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x < 0 || x >= HEIGHT || y < 0 || y >= WIDTH) return;

        super.setCellColor(x, y, color);
    }

    @Override
    public void onTurn(int step) {
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        drawScene();
    }

    private void drawScene() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellColor(x, y, Color.BLACK);
            }
        }

        rocket.draw(this);
        landscape.draw(this);
    }
}