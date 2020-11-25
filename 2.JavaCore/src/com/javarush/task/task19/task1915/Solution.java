package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String filePath;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream mySystemOut = new PrintStream(baos);
        System.setOut(mySystemOut);

        testString.printSomething();

        System.setOut(defaultPrintStream);

        try (FileOutputStream outputFile = new FileOutputStream(filePath)) {
            outputFile.write(baos.toByteArray());
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

