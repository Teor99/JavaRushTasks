package com.javarush.games.racer;

import com.javarush.engine.cell.*;

public class GameObject {
    public int x;
    public int y;
    public int[][] matrix;
    public int width;
    public int height;

    public GameObject(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
        this.width = matrix[0].length;
        this.height = matrix.length;
    }

    public void draw(Game game) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                game.setCellColor(x + this.x, y + this.y, Color.values()[matrix[y][x]]);
            }
        }
    }
}
