package com.javarush.task.task05.task0512;

/* 
Создать класс Circle
*/

public class Circle {
    //напишите тут ваш код
    private int centerX, centerY, radius, width, color;

    public void initialize(int centerX, int centerY, int radius, int width, int color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }

    public void initialize(int centerX, int centerY, int radius) {
        initialize(centerX, centerY, radius, 0, 0);
    }

    public void initialize(int centerX, int centerY, int radius, int width) {
        initialize(centerX, centerY, radius, width, 0);
    }

    public static void main(String[] args) {

    }
}
