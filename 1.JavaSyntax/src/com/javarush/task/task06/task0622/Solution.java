package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
10
8
9
3
5


*/

public class Solution {
    private static final int VAL = 5;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[Solution.VAL];
        //напишите тут ваш код
        for (int i = 0; i < Solution.VAL; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = Solution.VAL-1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int element : array) {
            System.out.println(element);
        }
    }
}
