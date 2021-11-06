package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public static final int COMPLEXITY = 5;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;
    private List<Bullet> playerBullets;
    private final static int PLAYER_BULLETS_MAX = 1;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) {
            showMessageDialog(Color.WHITE, "WIN", Color.GREEN, 100);
        } else {
            showMessageDialog(Color.WHITE, "GAME OVER", Color.RED, 100);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;

        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }

    private void createStars() {
        stars = new ArrayList<>();
        stars.add(new Star(0, 0));
        stars.add(new Star(0, 1));
        stars.add(new Star(0, 2));
        stars.add(new Star(0, 3));
        stars.add(new Star(1, 0));
        stars.add(new Star(1, 1));
        stars.add(new Star(1, 2));
        stars.add(new Star(1, 3));
    }

    private void createGame() {
        createStars();
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        playerBullets = new ArrayList<>();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        playerBullets.forEach(bullet -> bullet.draw(this));
        enemyBullets.forEach(bullet -> bullet.draw(this));
        enemyFleet.draw(this);
        playerShip.draw(this);
    }

    @Override
    public void onTurn(int step) {
        setScore(score);
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) {
            enemyBullets.add(bullet);
        }
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
        enemyBullets.forEach(Bullet::move);
        playerBullets.forEach(Bullet::move);
        playerShip.move();
    }

    private void removeDeadBullets() {
        List<Bullet> enemyBulletsForRemove = enemyBullets.stream()
                .filter(bullet -> !bullet.isAlive || bullet.y >= HEIGHT - 1)
                .collect(Collectors.toList());
        enemyBullets.removeAll(enemyBulletsForRemove);

        List<Bullet> playerBulletsForRemove = playerBullets.stream()
                .filter(bullet -> !bullet.isAlive || bullet.y + bullet.height < 0)
                .collect(Collectors.toList());
        playerBullets.removeAll(playerBulletsForRemove);
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        int killsScore = enemyFleet.verifyHit(playerBullets);
        score += killsScore;
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (enemyFleet.getBottomBorder() >= playerShip.y) {
            playerShip.kill();
        }

        if (!playerShip.isAlive) {
            stopGameWithDelay();
        } else if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            super.setCellValueEx(x, y, cellColor, value);
        }
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE) {
            if (isGameStopped) {
                createGame();
            } else {
                Bullet bullet = playerShip.fire();
                if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                    playerBullets.add(bullet);
                }
            }
        } else if (key == Key.LEFT) {
            playerShip.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            playerShip.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT
                || key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }
}
