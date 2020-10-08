package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr20 = new int[20];
        for (int i = 0; i < 20; i++) {
            arr20[i] = Integer.parseInt(reader.readLine());
        }

        int[] arr10_1 = new int[10];
        int[] arr10_2 = new int[10];

        for (int i = 0; i < 20; i++) {
            if (i < 10) {
                arr10_1[i] = arr20[i];
            } else {
                arr10_2[i-10] = arr20[i];
            }
        }

        for (int elem : arr10_2) {
            System.out.println(elem);
        }
    }
}
