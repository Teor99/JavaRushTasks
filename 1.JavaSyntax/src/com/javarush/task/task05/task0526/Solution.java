package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Man man1 = new Man("Vasya", 25, "Moscow");
        Man man2 = new Man("Leha", 23, "StPetersburg");
        Woman woman1 = new Woman("Anna", 26, "Yekaterinburg");
        Woman woman2 = new Woman("Olya", 30, "Vladivostok");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    // напишите тут ваш код
    public static class Man {
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman {
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
