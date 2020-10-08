package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(reader.readLine());
        if (value > 0) {
            System.out.print("положительное ");
        } else if (value < 0) {
            System.out.print("отрицательное ");
        } else {
            System.out.println("ноль");
            return;
        }

        if (value % 2 == 0) {
            System.out.println("четное число");
        } else {
            System.out.println("нечетное число");
        }
    }
}
