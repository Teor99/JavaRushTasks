package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут
        int min = 0;
        for (int i = 0; i < array.size(); i++) {
            if (i == 0) {
                min = array.get(i);
            } else {
                min = Math.min(min, array.get(i));
            }
        }

        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        return list;
    }
}
