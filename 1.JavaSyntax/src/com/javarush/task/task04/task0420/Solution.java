package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
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
        int temp;
        if (c > b) {
            temp = c;
            c = b;
            b = temp;
        }
        if (b > a) {
            temp = a;
            a = b;
            b = temp;
        }
        if (c > b) {
            temp = c;
            c = b;
            b = temp;
        }
        System.out.printf("%d %d %d\n", a, b, c);
    }
}