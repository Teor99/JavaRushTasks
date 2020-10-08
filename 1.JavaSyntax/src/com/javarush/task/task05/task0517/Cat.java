package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    private Cat(String name, int age, int weight, String address, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public Cat(String name) {
        this(name, 5, 5, null, "gray");
    }

    public Cat(String name, int weight, int age) {
        this(name, age, weight, null, "gray");
    }

    public Cat(String name, int age) {
        this(name, age, 5, null, "gray");
    }

    public Cat(int weight, String color) {
        this(null, 5, weight, null, color);
    }

    public Cat(int weight, String color, String address) {
        this(null, 5, weight, address, color);
    }

    public static void main(String[] args) {

    }
}
