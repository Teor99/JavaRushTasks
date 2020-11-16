package com.javarush.task.task18.task1821;

import java.io.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"f:\\1.txt"};

        if (args.length < 1) return;

        try (BufferedInputStream file = new BufferedInputStream(new FileInputStream(args[0]))) {
            int[] asciiTable = new int[256];
            int readedValue = -1;
            while ((readedValue = file.read()) != -1) {
                asciiTable[readedValue]++;
            }

            for (int i = 0; i < asciiTable.length; i++) {
                if (asciiTable[i] != 0) {
                    System.out.print((char)i);
                    System.out.print(" ");
                    System.out.println(asciiTable[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
