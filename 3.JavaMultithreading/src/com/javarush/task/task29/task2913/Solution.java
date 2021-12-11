package com.javarush.task.task29.task2913;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

/*
    public static String recursion(int a, int b) {
        if (a > b) {
            return a + " " + recursion(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + recursion(a + 1, b);
        }
    }
*/

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }

    public static String getAllNumbersBetween(int a, int b) {
        if (a == b) return String.valueOf(a);

        List<Integer> intList = IntStream.rangeClosed(Math.min(a, b), Math.max(a, b))
                .boxed()
                .collect(Collectors.toList());

        if (a > b) {
            Collections.reverse(intList);
        }

        List<String> stringList = intList.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        return String.join(" ", stringList);
    }
}