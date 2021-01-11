package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private Direction direction = Direction.RIGHT;

    private List<EnemyShip> ships;

    public EnemyFleet() {
        createShips();
    }

    private double getSpeed() {
        if (ships.isEmpty()) return 2.0;
        return Math.min(2.0, 3.0 / ships.size());
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int y = 0; y < ROWS_COUNT; y++) {
            for (int x = 0; x < COLUMNS_COUNT; x++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
    }

    public void move() {
        if (ships.isEmpty()) return;

        double speed = getSpeed();
        Direction directionBefore = direction;

        if (direction == Direction.LEFT && getLeftBorder() < 0) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
        }

        ships.forEach(ship -> ship.move(directionBefore == direction? direction : Direction.DOWN, speed));
    }

    public void draw(Game game) {
        ships.forEach(ship -> ship.draw(game));
    }

    private double getLeftBorder() {
        double minX = Double.MAX_VALUE;
        for (EnemyShip ship : ships) {
            minX = Math.min(minX, ship.x);
        }
        return minX;
    }

    private double getRightBorder() {
        double maxX = Double.MIN_VALUE;
        for (EnemyShip ship : ships) {
            maxX = Math.max(maxX, ship.x + ship.width);
        }
        return maxX;
    }
}
