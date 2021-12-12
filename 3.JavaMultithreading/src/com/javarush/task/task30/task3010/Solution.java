package com.javarush.task.task30.task3010;

import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    private static final String digits = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
//        args = new String[]{"12AS08z"};
//        args = new String[]{"00"};
//        args = new String[]{"12AS08Z/"};

        try {
            int radix = 2;

            for (char c : args[0].toLowerCase().toCharArray()) {
                int position = digits.indexOf(c);
                if (position == -1) {
                    System.out.println("incorrect");
                    return;
                } else {
                    radix = Math.max(radix, position + 1);
                }
            }

            System.out.println(radix);
        } catch (Exception e) {
            System.out.println("incorrect");
        }
    }
}