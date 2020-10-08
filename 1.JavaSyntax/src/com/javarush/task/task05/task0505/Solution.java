package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        Cat vaska = new Cat("vaska", 2, 2, 3);
        Cat murzik = new Cat("murzik", 3, 3, 4);
        Cat lelik = new Cat("lelik", 5, 3, 4);
        System.out.println(vaska.fight(murzik));
        System.out.println(murzik.fight(lelik));
        System.out.println(lelik.fight(vaska));
    }

    public static class Cat {

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageScore = Integer.compare(this.age, anotherCat.age);
            int weightScore = Integer.compare(this.weight, anotherCat.weight);
            int strengthScore = Integer.compare(this.strength, anotherCat.strength);

            int score = ageScore + weightScore + strengthScore;
            return score > 0; // return score > 0 ? true : false;
        }
    }
}
