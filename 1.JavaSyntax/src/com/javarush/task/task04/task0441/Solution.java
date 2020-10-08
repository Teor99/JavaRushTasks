package com.javarush.task.task04.task0441;

/* 
Как-то средненько
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

        if (a == b & b == c) {
            System.out.println(a);
        } else if (a == b) {
            System.out.println(a);
        } else if (a == c) {
            System.out.println(a);
        } else if (c == b) {
            System.out.println(c);
        } else if (a > b & a > c) {
            System.out.println(Math.max(b, c));
        } else if (b > a & b > c) {
            System.out.println(Math.max(a, c));
        } else if (c > a & c > b) {
            System.out.println(Math.max(a, b));
        }
    }
}
