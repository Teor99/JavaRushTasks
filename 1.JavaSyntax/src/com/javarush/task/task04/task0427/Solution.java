package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(reader.readLine());

        if (value < 1 | value > 999) return;

        if (value % 2 == 0) {
            System.out.print("четное ");
        } else {
            System.out.print("нечетное ");
        }

        if (value < 10) {
            System.out.println("однозначное число");
        } else if (value < 100) {
            System.out.println("двузначное число");
        } else {
            System.out.println("трехзначное число");
        }
    }
}
