package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;
    private Snake snake;
    private int turnDelay;
    private int score;
    private Apple apple;
    private boolean isGameStopped;


    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "VICTORY", Color.GREEN, 100);
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "GAME OVER", Color.RED, 100);
    }

    private void createGame() {
        snake = new Snake(WIDTH/2, HEIGHT/2);
        isGameStopped = false;
        score = 0;
        setScore(score);
        createNewApple();
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
    }

    @Override
    public void onKeyPress(Key key) {
        Direction direction = Direction.LEFT;
        switch (key) {
            case UP:
                direction = Direction.UP;
                break;
            case DOWN:
                direction = Direction.DOWN;
                break;
            case LEFT:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.RIGHT;
                break;
            case SPACE:
                if (isGameStopped) createGame();
                return;
        }
        snake.setDirection(direction);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            createNewApple();
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive) gameOver();
        if (snake.getLength() > GOAL) win();
        drawScene();
    }

    private void drawScene() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }

        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple() {
        do {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        } while (snake.checkCollision(apple));
    }
}
