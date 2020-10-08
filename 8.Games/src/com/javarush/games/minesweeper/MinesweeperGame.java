package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0;
    private int countFlags = 0;
    private int score = 0;
    private int countClosedTiles = SIDE * SIDE;
    private boolean isGameStopped = false;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        } else {
            if (0 <= x && x < SIDE && 0 <= y && y < SIDE){
                openTile(x, y);
            } else {
                System.err.println(x + " " + y + " onMouseLeftClick");
            }
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        if (0 <= x && x < SIDE && 0 <= y && y < SIDE){
            markTile(x, y);
        } else {
            System.err.println(x + " " + y + " onMouseRightClick");
        }
    }

    private void restart() {
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(score);
        createGame();
        isGameStopped = false;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "GAME OVER", Color.RED, 100);
    }

    private void markTile(int x, int y) {
        if (isGameStopped) return;

        GameObject currentCell = gameField[y][x];
        if (currentCell.isOpen) return;

        if (countFlags == 0 && !currentCell.isFlag) return;

        if (!currentCell.isFlag) {
            currentCell.isFlag = true;
            countFlags--;
            setCellValue(x,y, MinesweeperGame.FLAG);
            setCellColor(x,y,Color.YELLOW);
        } else {
            currentCell.isFlag = false;
            countFlags++;
            setCellValue(x,y, "");
            setCellColor(x,y,Color.ORANGE);
        }
    }

    private void openTile(int x, int y) {
        if (isGameStopped) return;

        GameObject currentCell = gameField[y][x];
        if (currentCell.isFlag || currentCell.isOpen) return;

        currentCell.isOpen = true;
        countClosedTiles--;
        setCellColor(x, y, Color.GREEN);
        if (currentCell.isMine) {
            // Отрисовка мины
            setCellValueEx(x, y, Color.RED, MinesweeperGame.MINE);
            gameOver();
            return;
        } else if (currentCell.countMineNeighbors != 0) {
            // Отрисовка количества соседей мин
            setCellNumber(x, y, currentCell.countMineNeighbors);
        } else {
            setCellValue(x, y, "");

            // Открыть всех соседей (не мин) && (не открытых)
            List<GameObject> listNeighbors = getNeighbors(currentCell);
            for (GameObject cellNeighbor : listNeighbors) {
                if (!cellNeighbor.isOpen) openTile(cellNeighbor.x, cellNeighbor.y);
            }
        }

        score += 5;
        setScore(score);

        if (countClosedTiles == countMinesOnField) {
            win();
        }
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "VICTORY", Color.GREEN, 100);
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                GameObject currentCell = gameField[y][x];

                if (!currentCell.isMine) {
                    List<GameObject> listNeighbors = getNeighbors(currentCell);
                    for (GameObject cellNeighbor : listNeighbors) {
                        if (cellNeighbor.isMine) currentCell.countMineNeighbors++;
                    }
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }
}