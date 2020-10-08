package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int positiveNumbersCounter = 0;
        int negativeNumbersCounter = 0;

        if (a > 0) positiveNumbersCounter++;
        if (b > 0) positiveNumbersCounter++;
        if (c > 0) positiveNumbersCounter++;

        if (a < 0) negativeNumbersCounter++;
        if (b < 0) negativeNumbersCounter++;
        if (c < 0) negativeNumbersCounter++;

        System.out.println("количество отрицательных чисел: " + negativeNumbersCounter);
        System.out.println("количество положительных чисел: " + positiveNumbersCounter);
    }
}
