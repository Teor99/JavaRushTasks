package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "VICTORY", Color.GREEN, 100);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "GAME OVER", Color.RED, 100);
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
            }

            return;
        }

        if (!canUserMove()) {
            gameOver();
            return;
        }

        switch (key) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }

        if (key == Key.UP || key == Key.DOWN || key == Key.LEFT || key == Key.RIGHT) drawScene();
    }


    private void rotateClockwise() {
        int[][] tmpArray = new int[SIDE][SIDE];

        // rotate
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                tmpArray[x][SIDE - 1 - y] = gameField[y][x];
            }
        }

        // copy
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                gameField[y][x] = tmpArray[y][x];
            }
        }
    }

    private int getMaxTileValue() {
        int max = 0;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                max = Math.max(max, gameField[y][x]);
            }
        }

        return max;
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveLeft() {
        boolean isModified = false;
        for (int y = 0; y < gameField.length; y++) {
            if (compressRow(gameField[y])) {
                isModified = true;
            }

            if (mergeRow(gameField[y])) {
                compressRow(gameField[y]);
                isModified = true;
            }

        }
        if (isModified) createNewNumber();
    }

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
/*
        for (int i = 0; i < gameField.length; i++) {
            System.out.println(Arrays.toString(gameField[i]));
        }
*/
        drawScene();
//        compressRow(new int[]{0, 2, 0, 2});
//        compressRow(new int[]{2, 2, 2, 2});
//        compressRow(new int[]{0, 4, 0, 2});
//        compressRow(new int[]{4, 2, 0, 2});
//        compressRow(new int[]{2, 4, 0, 0});

//        mergeRow(new int[]{4, 4, 0, 0});
//        mergeRow(new int[]{2, 2, 2, 2});
//        mergeRow(new int[]{4, 2, 2, 0});
//        mergeRow(new int[]{0, 2, 2, 0});
//        mergeRow(new int[]{0, 2, 2, 2});
//        mergeRow(new int[]{4, 0, 4, 0});

    }

    private void drawScene() {
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[0].length; x++) {
//                setCellColor(x, y, Color.LIGHTSEAGREEN);
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private boolean mergeRow(int[] row) {
        boolean isRowModified = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] == 0) continue;

            if (row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                isRowModified = true;

                score += row[i];
                setScore(score);
            }
        }

        return isRowModified;
    }

    private boolean compressRow(int[] row) {
        boolean isRowModified = false;
        boolean isCellsTouched;
        do {
            isCellsTouched = false;
            for (int i = row.length - 1; i > 0; i--) {
                if (row[i] != 0 && row[i - 1] == 0) {
                    int tmp = row[i];
                    row[i] = row[i - 1];
                    row[i - 1] = tmp;
                    isCellsTouched = true;
                    isRowModified = true;
                }
            }
        } while (isCellsTouched);

        return isRowModified;
    }

    private void createNewNumber() {
        if (getMaxTileValue() >= 2048) {
            win();
            return;
        }

        int x;
        int y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[y][x] != 0);

        if (getRandomNumber(10) == 9) {
            // 10% вероятность
            gameField[y][x] = 4;
        } else {
            // 10% вероятность
            gameField[y][x] = 2;
        }
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 0:
                return Color.LIGHTYELLOW;
            case 2:
                return Color.LIGHTCORAL;
            case 4:
                return Color.ALICEBLUE;
            case 8:
                return Color.BLUE;
            case 16:
                return Color.BLUEVIOLET;
            case 32:
                return Color.DARKKHAKI;
            case 64:
                return Color.DARKRED;
            case 128:
                return Color.DARKSALMON;
            case 256:
                return Color.MAROON;
            case 512:
                return Color.MAGENTA;
            case 1024:
                return Color.PAPAYAWHIP;
            case 2048:
                return Color.SPRINGGREEN;
        }
        return null;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        setCellValueEx(x, y, getColorByValue(value), value == 0 ? "" : Integer.toString(value));
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }

    private boolean canUserMove() {
        // поиск пустых клеток
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[y][x] == 0) return true;
            }
        }

        // поиск 2х клеток с одинаковыми значениями, по горизонтали и вертикали
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (x + 1 < SIDE && gameField[y][x] == gameField[y][x + 1]) return true;
                if (x - 1 >= 0 && gameField[y][x] == gameField[y][x - 1]) return true;

                if (y + 1 < SIDE && gameField[y][x] == gameField[y + 1][x]) return true;
                if (y - 1 >= 0 && gameField[y][x] == gameField[y - 1][x]) return true;
            }
        }

        return false;
    }
}
