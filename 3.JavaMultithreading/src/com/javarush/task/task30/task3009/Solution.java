package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> resultSet = new HashSet<>();
        try {
            int i = Integer.parseInt(number, 10);
            for (int radix = 2; radix <= 36; radix++) {
                String numberInRadix = Integer.toString(i, radix);
                if (isPalindrome(numberInRadix)) {
                    resultSet.add(radix);
                }
            }
        } catch (NumberFormatException ignored) {
        }

        return resultSet;
    }

    private static boolean isPalindrome(String numberInRadix) {
        return numberInRadix.equals(new StringBuilder(numberInRadix).reverse().toString());
    }
}