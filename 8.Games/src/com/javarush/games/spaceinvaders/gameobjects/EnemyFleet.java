package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private Direction direction = Direction.RIGHT;

    private List<EnemyShip> ships;

    public EnemyFleet() {
        createShips();
    }

    public int getShipsCount() {
        return ships.size();
    }

    public int verifyHit(List<Bullet> bullets) {
        if (bullets.isEmpty()) return 0;
        int totalScore = 0;
        for (EnemyShip enemyShip : ships) {
            for (Bullet bullet : bullets) {
                if (bullet.isAlive && enemyShip.isAlive && bullet.isCollision(enemyShip)) {
                    bullet.kill();
                    enemyShip.kill();
                    totalScore += enemyShip.score;
                }
            }
        }

        return totalScore;
    }

    public double getBottomBorder() {
        double maxY = 0.0;
        EnemyShip es = ships.stream()
                .max(Comparator.comparing(enemyShip -> enemyShip.y + enemyShip.height))
                .orElse(null);

        if (es != null) {
            maxY = es.y + es.height;
        }

        return maxY;
    }

    public void deleteHiddenShips() {
        List<EnemyShip> shipsForRemove = ships.stream()
                .filter(enemyShip -> !enemyShip.isVisible())
                .collect(Collectors.toList());
        ships.removeAll(shipsForRemove);
    }

    public Bullet fire(Game game) {
        if (ships.isEmpty()) return null;
        int randomNumber = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);
        if (randomNumber > 0) return null;

        int randomShipIndex = game.getRandomNumber(ships.size());
        return ships.get(randomShipIndex).fire();
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

        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
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
