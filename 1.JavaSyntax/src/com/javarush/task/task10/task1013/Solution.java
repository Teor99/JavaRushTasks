package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private boolean sex;
        private int age;
        private int childCount;
        private String name;
        private String address;
        private String country;


        public Human() {
        }

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(boolean sex, int age, int childCount, String name, String address, String country) {
            this.sex = sex;
            this.age = age;
            this.childCount = childCount;
            this.name = name;
            this.address = address;
            this.country = country;
        }

        public Human(boolean sex, int age, int childCount, String name, String address) {
            this.sex = sex;
            this.age = age;
            this.childCount = childCount;
            this.name = name;
            this.address = address;
        }

        public Human(boolean sex, int age, int childCount, String name) {
            this.sex = sex;
            this.age = age;
            this.childCount = childCount;
            this.name = name;
        }

        public Human(boolean sex, int age, int childCount) {
            this.sex = sex;
            this.age = age;
            this.childCount = childCount;
        }

        public Human(boolean sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        public Human(boolean sex, int age, String name) {
            this.sex = sex;
            this.age = age;
            this.name = name;
        }
    }
}
