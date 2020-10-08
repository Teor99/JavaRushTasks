package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/
/*
public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }



    public static void main(String[] args) {

    }
}
*/

/*
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int cat1 = 0;
        int cat2 = 0;

        if (this.age > anotherCat.age) {
            cat1++;
        } else if (this.age < anotherCat.age) {
            cat2++;
        }
        if (this.weight > anotherCat.weight) {
            cat1++;
        } else {
            cat2++;
        }
        if (this.strength > anotherCat.strength) {
            cat1++;
        } else {
            cat2++;
        }

        if (cat1 > cat2) {
            return true;
        } else {
            return false;
        }
    }

    /*
    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код

        int advantageThisCat = 0, advantageAnotherCat = 0;

        if (this.age - anotherCat.age > 0) {
            advantageThisCat++;
        } else if (this.age - anotherCat.age < 0) {
            advantageAnotherCat++;
        }

        if (this.weight - anotherCat.weight > 0) {
            advantageThisCat++;
        } else if (this.weight - anotherCat.weight < 0) {
            advantageAnotherCat++;
        }

        if (this.strength - anotherCat.strength > 0) {
            advantageThisCat++;
        } else if (this.strength - anotherCat.strength < 0) {
            advantageAnotherCat++;
        }

        return advantageThisCat > advantageAnotherCat;
    }
*/
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        cat1.age = 1;
        cat1.weight = 1;
        cat1.strength = 1;

        cat2.age = 1;
        cat2.weight = 1;
        cat2.strength = 10;

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));


    }
}