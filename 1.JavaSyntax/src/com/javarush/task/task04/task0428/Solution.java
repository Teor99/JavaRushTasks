package com.javarush.task.task04.task0428;

/* 
Положительное число
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
        if (a > 0) positiveNumbersCounter++;
        if (b > 0) positiveNumbersCounter++;
        if (c > 0) positiveNumbersCounter++;

        System.out.println(positiveNumbersCounter);
    }
}
