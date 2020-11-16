package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"f:\\1.png"};

        if (args.length < 1) return;

        try (BufferedReader inputFile = new BufferedReader(new FileReader(args[0]))) {
            int countOfCharsInFile = 0;
            int countOfSpaceInFile = 0;

            int readedValue;
            while ((readedValue = inputFile.read()) != -1) {
                countOfCharsInFile++;
                char symbol = (char) readedValue;
                if (symbol == ' ') countOfSpaceInFile++;
            }

            if (countOfCharsInFile != 0) {
                double result = countOfSpaceInFile / (double)countOfCharsInFile * 100;
                System.out.printf("%.2f", result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
