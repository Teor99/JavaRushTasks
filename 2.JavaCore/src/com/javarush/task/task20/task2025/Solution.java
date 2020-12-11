package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        long beginTime = System.currentTimeMillis();
        List<Long> list = new ArrayList<>();
        long[][] powTable = new long[10][20];
        for (int number = 0; number < powTable.length; number++) {
            for (int degree = 0; degree < powTable[0].length; degree++) {
                powTable[number][degree] = (long) Math.pow(number, degree);
            }
        }

        for (long i = 1; i < N; i++) {
            int symbolCounter = 0;
            long tmp = i;
            while (tmp != 0) {
                tmp /= 10;
                symbolCounter++;
            }

            tmp = i;
            long summ = 0;
            while (tmp != 0) {
                int ostatok = (int) (tmp % 10);
                tmp /= 10;

                summ += powTable[ostatok][symbolCounter];
            }

            if (i == summ) {
                list.add(i);
                System.err.println(i + " (" + (System.currentTimeMillis() - beginTime) + "ms) (" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "Mb)");
            }
        }

        long[] result = new long[list.size()];
        for (int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Long.MAX_VALUE);

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
