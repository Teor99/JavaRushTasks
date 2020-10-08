package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<>();
        while (set.size() < 20) {
            set.add((int)(Math.random()*100));
        }
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        set.removeIf(value -> value > 10);
        return set;
    }

    public static void main(String[] args) {
/*
        Set<Integer> set = createSet();
        System.out.println(set);
        removeAllNumbersGreaterThan10(set);
        System.out.println(set);
*/
    }
}
