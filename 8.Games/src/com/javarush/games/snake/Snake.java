package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;

    public int getLength() {
        return snakeParts.size();
    }

    public void setDirection(Direction direction) {
        if (direction == Direction.UP && this.direction == Direction.DOWN)
            return;
        if (direction == Direction.DOWN && this.direction == Direction.UP)
            return;
        if (direction == Direction.LEFT && this.direction == Direction.RIGHT)
            return;
        if (direction == Direction.RIGHT && this.direction == Direction.LEFT)
            return;

        if (snakeParts.get(0).x == snakeParts.get(1).x && (this.direction == Direction.LEFT || this.direction == Direction.RIGHT))
            return;
        if (snakeParts.get(0).y == snakeParts.get(1).y && (this.direction == Direction.UP || this.direction == Direction.DOWN))
            return;

        this.direction = direction;
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject snakePart : snakeParts) {
            if (gameObject.x == snakePart.x && gameObject.y == snakePart.y)
                return true;
        }

        return false;
    }

    public GameObject createNewHead() {
        int tmpX = snakeParts.get(0).x;
        int tmpY = snakeParts.get(0).y;

        switch (direction) {
            case UP:
                tmpY--;
                break;
            case DOWN:
                tmpY++;
                break;
            case LEFT:
                tmpX--;
                break;
            case RIGHT:
                tmpX++;
                break;
        }

        return new GameObject(tmpX, tmpY);
    }

    public void removeTail() {
        if (!snakeParts.isEmpty()) {
            snakeParts.remove(snakeParts.size() - 1);
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();

        // Проверка на выход за границы поля
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT) {
            isAlive = false;
            return;
        }

        // Проверка на столкновение змейки с собой
        if (checkCollision(newHead)) {
            isAlive = false;
            return;
        }

        snakeParts.add(0, newHead);

        // Если координаты головы и яблока совпадают = яблоко съедено
        if (newHead.x == apple.x && newHead.y == apple.y) {
            apple.isAlive = false;
            return;
        }

        removeTail();
    }

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x+1, y));
        snakeParts.add(new GameObject(x+2, y));
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject part = snakeParts.get(i);
            Color color = (isAlive)? Color.BLACK : Color.RED;

            if (i == 0) {
                game.setCellValueEx(part.x, part.y, Color.NONE, HEAD_SIGN, color, 75);
            } else {
                game.setCellValueEx(part.x, part.y, Color.NONE, BODY_SIGN, color, 75);
            }
        }
    }
}
