package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sort(new Integer[]{13, 8, 15, 5, 17})));
//        System.out.println(Arrays.toString(sort(new Integer[]{10, 11, 12, 13, 14, 15, 16})));
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array, new MedianComparator(array));
        return array;
    }


    public static class MedianComparator implements Comparator<Integer> {
        private final Integer[] array;
        private final double medianValue;

        public MedianComparator(Integer[] array) {
            this.array = array;
            this.medianValue = getMedianOfArray(array);
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            double abs1 = Math.abs(medianValue - o1);
            double abs2 = Math.abs(medianValue - o2);
            if (abs1 == abs2) {
                return o1 - o2;
            } else {
                return (int) (abs1 - abs2);
            }
        }

        private double getMedianOfArray(Integer[] array) {
            Arrays.sort(array);

            if (array.length % 2 == 0) {
                // если количество элементов четное
                // возвращаем среднне арифметическое двух элементов в середине массива
                int right = array.length / 2;
                int left = right - 1;
                return (array[left] + array[right]) / 2.0;
            } else {
                // иначе возвращаем средний элемент
                return array[array.length / 2];
            }
        }
    }
}
