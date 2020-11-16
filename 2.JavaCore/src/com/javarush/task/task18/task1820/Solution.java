package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
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

        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath))) {
            StringBuilder outputLine = new StringBuilder();
            String inputLine;
            while ((inputLine = inputFile.readLine()) != null) {
                String[] numbers = inputLine.split(" ");
                for (int i = 0; i < numbers.length; i++) {
                    try {
                        Double value = Double.parseDouble(numbers[i]);
                        Long result = Math.round(value);
                        outputLine.append(result).append(" ");
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());
                        continue;
                    }
                }
            }

            try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFilePath))) {
                outputFile.write(outputLine.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
