package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    private int top, left, width, height;

    public void initialize(int top, int left) {
        initialize(top, left, 0 , 0);
    }

    public void initialize(Rectangle rect) {
        this.top = rect.top;
        this.left = rect.left;
        this.width = rect.width;
        this.height = rect.height;
    }

    public void initialize(int top, int left, int width) {
        initialize(top, left, width, width);
    }

    public void initialize(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
