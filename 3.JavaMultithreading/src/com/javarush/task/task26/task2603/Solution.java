package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {
/*        List<Human> list = new ArrayList<>();
        list.add(new Human("Pasha", 18, true));
        list.add(new Human("Lena", 20, false));
        list.add(new Human("Misha", 22, true));
        list.add(new Human("Evgen", 25, true));
        list.add(new Human("Kate", 20, false));
        list.add(new Human("Kate", 20, false));
        list.add(new Human("Hate", 25, false));
        list.add(new Human("Kate", 25, false));
        list.add(new Human("Kate", 25, false));

        Comparator<Human> ageComparator = (o1, o2) -> o1.age - o2.age;
        Comparator<Human> nameComparator = (o1, o2) -> o1.name.compareTo(o2.name);

        list.sort(new CustomizedComparator<Human>(new Comparator[]{ageComparator, nameComparator}));

        for (Human human : list) {
            System.out.println(human);
        }*/
    }

/*    public static class Human {
        private String name;
        private int age;
        private boolean male;

        public Human(String name, int age, boolean male) {
            this.name = name;
            this.age = age;
            this.male = male;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", male=" + male +
                    '}';
        }
    }*/

    public static class CustomizedComparator<T> implements Comparator<T> {
        private final Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        @Override

        public int compare(T o1, T o2) {
            int compareResult = 0;

            for (Comparator<T> comparator : comparators) {
                compareResult = comparator.compare(o1, o2);
                if (compareResult != 0) {
                    break;
                }
            }

            return compareResult;
        }
    }
}
