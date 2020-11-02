package com.javarush.games.racer;

import com.javarush.engine.cell.*;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x < 0 || y < 0 || x >= WIDTH || y >= HEIGHT) return;

        super.setCellColor(x, y, color);
    }

    private void createGame() {
        drawScene();
    }

    private void drawScene() {
        drawField();
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                //
                Color color = Color.GREEN;
                if (x == CENTER_X) {
                    color = Color.WHITE;
                } else if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH) {
                    color = Color.DIMGREY;
                }

                setCellColor(x, y, color);
            }
        }
    }
}