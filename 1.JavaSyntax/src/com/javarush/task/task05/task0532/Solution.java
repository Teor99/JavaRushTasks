package com.javarush.task.task05.task0532;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cycles = Integer.parseInt(reader.readLine());
        if (cycles < 1) return;

        int maximum = 0;
        for (int i = 0; i < cycles; i++) {
            int readValue = Integer.parseInt(reader.readLine());
            if (i == 0) {
                maximum = readValue;
            } else {
                maximum = Math.max(maximum, readValue);
            }
        }

        //напишите тут ваш код
        System.out.println(maximum);
    }
}
