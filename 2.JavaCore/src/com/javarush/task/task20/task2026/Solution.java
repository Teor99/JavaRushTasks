package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static class Rects {
        private List<Rect> list;

        public Rects() {
            list = new ArrayList<>();
        }

        public void add(Rect rect) {
            list.add(rect);
        }

        public int size() {
            return list.size();
        }

        public boolean isContainCoordinate(int x, int y) {
            for (Rect rect : list) {
                if (rect.isContainCoordinate(x, y)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class Rect {
        private int x;
        private int y;
        private int width;
        private int heigth;

        public Rect(int x, int y, int width, int heigth) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.heigth = heigth;
        }

        public boolean isContainCoordinate(int x, int y) {
            return this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + heigth;
        }
    }

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        Rects rects = new Rects();

        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[0].length; x++) {
                if (a[y][x] != 1) continue;

                if (rects.isContainCoordinate(x, y)) {
                    continue;
                } else {
                    rects.add(new Rect(x, y, getRectWidth(x, y, a), getRectHeigth(x, y, a)));
                }
            }
        }

        return rects.size();
    }

    private static int getRectHeigth(int fromX, int fromY, byte[][] a) {
        int heigth = 0;

        for (int y = fromY; y < a.length; y++) {
            if (a[y][fromX] == 1) {
                heigth++;
            } else {
                break;
            }
        }

        return heigth;
    }

    private static int getRectWidth(int fromX, int fromY, byte[][] a) {
        int width = 0;

        for (int x = fromX; x < a[0].length; x++) {
            if (a[fromY][x] == 1) {
                width++;
            } else {
                break;
            }
        }

        return width;
    }
}
