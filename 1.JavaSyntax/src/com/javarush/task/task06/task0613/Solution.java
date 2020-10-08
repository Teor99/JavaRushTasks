package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        // Создай 10 котов
        Cat[] cats = new Cat[10];
        for (int i = 0; i < 10; i++) {
            cats[i] = new Cat();
        }
        // Выведи значение переменной catCount
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        // Создай статическую переменную catCount
        public static int catCount = 0;
        // Создай конструктор

        public Cat() {
            Cat.catCount++;
        }
    }
}
