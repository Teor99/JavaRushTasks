package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
//    private static final String REMOVE_SYMBOLS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n";

    public static void main(String[] args) {
//        String s = System.lineSeparator();
//        int i = 1;

        if (args.length == 0)return;

        String inputFilePath; //= "f:\\1.txt";
        String outputFilePath; //= "f:\\2.txt";

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            inputFilePath = console.readLine();
            outputFilePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath))) {
            try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFilePath))) {
                String line;
                while ((line = inputFile.readLine()) != null) {
                    line = line.replaceAll("\\p{Punct}", "");
                    outputFile.write(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
