package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        String inputFilePath;
        String outputFilePath;

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            inputFilePath = console.readLine();
            outputFilePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

//        inputFilePath = "f:\\1.txt";

        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath))) {
            try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFilePath))) {
                String line;
                Pattern pattern = Pattern.compile("^\\d+$");
                StringBuilder result = new StringBuilder();
                while ((line = inputFile.readLine()) != null) {
                    String[] splitLineArray = line.split("(?U)\\W+");
                    for (String splitLine : splitLineArray) {

                        Matcher matcher = pattern.matcher(splitLine);
                        while (matcher.find()) {
                            result.append(splitLine).append(" ");
                        }
                    }
                }

                outputFile.write(result.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
