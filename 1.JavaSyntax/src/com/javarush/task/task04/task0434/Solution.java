package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int x = 1, y = 1;
        while (y < 11) {
            while (x < 11) {
                System.out.print(y * x);
                if (x == 10) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
                x++;
            }
            y++;
            x = 1;
        }
    }
}
