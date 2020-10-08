package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Cat catGrandfather = new Cat(reader.readLine());
        Cat catGrandmother = new Cat(reader.readLine());
        Cat catFather = new Cat(reader.readLine(), null , catGrandfather);
        Cat catMother = new Cat(reader.readLine(), catGrandmother, null);
        Cat catSon = new Cat(reader.readLine(), catMother, catFather);
        Cat catDaughter = new Cat(reader.readLine(), catMother, catFather);

        System.out.println(catGrandfather);
        System.out.println(catGrandmother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this(name);
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            String result = "The cat's name is " + name;
            if (mother == null) {
                result += ", no mother";
            } else {
                result += ", mother is " + mother.name;
            }
            if (father == null) {
                result += ", no father";
            } else {
                result += ", father is " + father.name;
            }

            return result;
        }
    }

}
