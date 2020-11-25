package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFilePath = reader.readLine();
        String outputFilePath = reader.readLine();
        reader.close();

        BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFilePath));
        int ordinalNumber = 1;
        int readValue = -1;
        while ((readValue = inputFile.read()) != -1) {
            if (ordinalNumber % 2 == 0) {
                outputFile.write(readValue);
            }
            ordinalNumber++;
        }
        outputFile.close();
        inputFile.close();
    }
}