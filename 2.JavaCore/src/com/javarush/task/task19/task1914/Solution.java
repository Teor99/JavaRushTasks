package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        PrintStream oldOut = System.out;
        System.setOut(printStream);

        testString.printSomething();
        System.setOut(oldOut);

        String line = byteArrayOutputStream.toString();
        line = line.replaceAll("=", "");
        line = line.replaceAll(" ", "");
        line = line.replaceAll(System.lineSeparator(), "");

        String result = byteArrayOutputStream.toString().replaceAll(System.lineSeparator(), "");

        if (line.contains("+")) {
            int firstTerm = Integer.parseInt(line.split("\\+")[0]);
            int secondTerm = Integer.parseInt(line.split("\\+")[1]);
            result += (firstTerm + secondTerm);
        } else if (line.contains("-")) {
            int firstTerm = Integer.parseInt(line.split("-")[0]);
            int secondTerm = Integer.parseInt(line.split("-")[1]);
            result += (firstTerm - secondTerm);
        } else if (line.contains("*")) {
            int firstTerm = Integer.parseInt(line.split("\\*")[0]);
            int secondTerm = Integer.parseInt(line.split("\\*")[1]);
            result += (firstTerm * secondTerm);
        }

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
//            System.out.println("3 - 6 = ");
//            System.out.println("3 * 6 = ");
        }
    }
}

