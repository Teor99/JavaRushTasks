package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(reader.readLine());
        if (value > 0) {
            value *= 2;
        } else if (value < 0) {
            value++;
        }
        System.out.println(value);
    }

}