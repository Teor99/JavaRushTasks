package com.javarush.task.task07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");

        strings.add(1, "именно");
        strings.add(3, "именно");
        strings.add(5, "именно");

        strings.forEach(System.out::println);
    }
}
