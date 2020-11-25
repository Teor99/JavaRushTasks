package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"f:\\4.txt", "f:\\5.txt"};
        if (args.length != 2) return;

        try (BufferedReader inputFile = new BufferedReader(new FileReader(args[0]));
             BufferedWriter outputFile = new BufferedWriter(new FileWriter(args[1]))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] splitedLine = line.split("\\s+");
                for (String shortLine : splitedLine) {
                    if (shortLine.matches(".*\\d+.*")) {
                        outputFile.write(shortLine);
                        outputFile.write(" ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
