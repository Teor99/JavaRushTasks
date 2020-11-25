package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    private static int counter = 0;

    public static void main(String[] args) throws IOException {

        String fileName;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        }

        StringBuilder text = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            char currentChar;
            while (reader.ready()) {
                currentChar = (char) reader.read();
                text.append(currentChar);

            }
        }

        String replacedString = text.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");

        for (String x : replacedString.split(" ")) {
            if (x.equals("world")) {
                counter++;
            }
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        String inputFilePath;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            inputFilePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

//        inputFilePath = "f:\\1.txt";

        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath))) {
            int countOfFindWords = 0;
            String line;
            Pattern pattern = Pattern.compile("^world$");
            while ((line = inputFile.readLine()) != null) {
                String[] shortLineArray = line.split("\\W+");
                for (String shortLine : shortLineArray) {
//                    System.err.print("find in line: \"" + shortLine + "\" ");

                    Matcher matcher = pattern.matcher(shortLine);
                    while (matcher.find()) {
                        countOfFindWords++;
//                        System.err.print("ОК");
                    }
//                    System.err.println();
                }
            }

            System.out.println(countOfFindWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
