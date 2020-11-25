package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultSystemOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream mySystemOut = new PrintStream(baos);
        System.setOut(mySystemOut);

        testString.printSomething();
        System.setOut(defaultSystemOut);

        String[] splitedLine = baos.toString().split(System.lineSeparator());
        int counter = 0;
        for (String shortLine : splitedLine) {
            System.out.println(shortLine);
            counter++;

            if (counter == 2) {
                counter = 0;
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}