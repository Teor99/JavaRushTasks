package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"f:\\4.txt", "f:\\5.txt"};
        if (args.length != 2) return;

        try (BufferedReader inputFile = new BufferedReader(new FileReader(args[0]));
             BufferedWriter outputFile = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] splitedLine = line.split("\\s+");
                for (String shortLine : splitedLine) {
//                    if (shortLine.matches("(?U)\\w{7,}")) {
                    if (shortLine.length() > 6) {
                        result.append(shortLine);
                        result.append(" ");
                    }
                }
            }

            String resultLine = result.toString().trim().replaceAll(" ", ",");
            outputFile.write(resultLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
