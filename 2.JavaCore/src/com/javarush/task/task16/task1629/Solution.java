package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final int COUNT_OF_LINES = 3;

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();

        t2.join();

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread {
        private String[] lines = new String[COUNT_OF_LINES];

        @Override
        public void run() {
            for (int i = 0; i < lines.length; i++) {
                try {
                    lines[i] = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printResult() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < lines.length; i++) {
                result.append(lines[i]);
                result.append(" ");
            }

            System.out.println(result.toString().trim());
        }
    }

    //add your code here - добавьте код тут
}
