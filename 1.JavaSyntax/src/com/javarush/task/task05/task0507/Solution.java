package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0.0;
        int counter = 0;
        while (true) {
            int value = Integer.parseInt(reader.readLine());
            if (value == -1) break;
            sum += value;
            counter++;
        }
        if (counter > 0) System.out.println(sum / counter);
    }
}

