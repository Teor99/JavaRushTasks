package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human children1 = new Human("Василий", true, 12);
        Human children2 = new Human("Максим", true, 5);
        Human children3 = new Human("Юлия", false, 10);

        Human father = new Human("Сергей", true, 40);
        father.children.add(children1);
        father.children.add(children2);
        father.children.add(children3);

        Human mother = new Human("Юлия", false, 35);
        mother.children.add(children1);
        mother.children.add(children2);
        mother.children.add(children3);

        Human grandFather1 = new Human("Василий", true, 60);
        grandFather1.children.add(mother);
        Human grandMother1 = new Human("Анна", false, 51);
        grandMother1.children.add(mother);

        Human grandFather2 = new Human("Олег", true, 58);
        grandFather2.children.add(father);
        Human grandMother2 = new Human("Ирина", false, 50);
        grandMother2.children.add(father);

        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandMother2);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
