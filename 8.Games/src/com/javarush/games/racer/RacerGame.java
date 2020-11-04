package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private FinishLine finishLine;
    private boolean isGameStopped;
    private ProgressBar progressBar;
    private int score;

    private void win() {
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.WHITE, "VICTORY", Color.GREEN, 100);
    }

    private void gameOver() {
        isGameStopped = true;
        stopTurnTimer();
        player.stop();
        showMessageDialog(Color.WHITE, "GAME OVER", Color.RED, 100);
    }

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
        score = 3500;
        isGameStopped = false;
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        finishLine.draw(this);
        player.draw(this);
        roadManager.draw(this);
        progressBar.draw(this);
    }

    private void moveAll() {
        roadMarking.move(player.speed);
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        player.move();
        progressBar.move(roadManager.getPassedCarsCount());
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            player.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            player.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            player.speed = 2;
        } else if (key == Key.SPACE && isGameStopped) {
            createGame();
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && player.getDirection() == Direction.LEFT) {
            player.setDirection(Direction.NONE);
        } else if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT) {
            player.setDirection(Direction.NONE);
        } else if (key == Key.UP) {
            player.speed = 1;
        }
    }

    @Override
    public void onTurn(int step) {
        if (roadManager.checkCrush(player)) {
            gameOver();
            drawScene();
            return;
        }

        if (finishLine.isCrossed(player)) {
            win();
            drawScene();
            return;
        }

        roadManager.generateNewRoadObjects(this);
        if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) {
            finishLine.show();
        }

        moveAll();
        score -= 5;
        setScore(score);
        drawScene();
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