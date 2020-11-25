package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена знаков
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
                int readValue;
                while ((readValue = inputFile.read()) != -1) {
                    if (readValue == '.') readValue = '!';
                    outputFile.write(readValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

