package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        int maximum = 0;
        int minimum = 0;

        //напишите тут ваш код
        int[] array = getInts();

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                maximum = minimum = array[i];
            } else {
                minimum = Math.min(minimum, array[i]);
                maximum = Math.max(maximum, array[i]);
            }
        }

        System.out.print(maximum + " " + minimum);
    }

    //напишите тут ваш код
    public static int[] getInts() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] result = new int[20];
        for (int i = 0; i < 20; i++) {
            result[i] = Integer.parseInt(reader.readLine());
        }
        return result;
    }
}
