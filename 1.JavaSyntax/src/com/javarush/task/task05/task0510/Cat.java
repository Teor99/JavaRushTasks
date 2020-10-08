package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age ;
    private int weight;
    private String address;
    private String color;

    private void initialize(String name, int age, int weight, String address, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public void initialize(String name) {
        this.initialize(name, 5, 5, null, "gray");
    }

    public void initialize(String name, int age) {
        this.initialize(name, age, 5, null, "gray");
    }

    public void initialize(String name, int weight,  int age) {
        this.initialize(name, age, weight, null, "gray");
    }

    public void initialize(int weight, String color) {
        this.initialize(null, 5, weight, null, color);
    }

    public void initialize(int weight, String color, String address) {
        this.initialize(null, 5, weight, address, color);
    }

    public static void main(String[] args) {

    }
}
