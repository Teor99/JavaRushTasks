package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
//        words.add("А");
//        words.add("Б");
        words.add("В");
    }

    public static void main(String[] args) {
        String filePath;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

//        filePath = "f:\\4.txt";

        try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = file.readLine()) != null) {
                String[] splitedLine = line.split("\\s+");
                int countFoundWords = 0;
                for (String word : words) {
                    for (String shortLine : splitedLine) {
                        if (shortLine.equals(word)){
                            countFoundWords++;
//                            break;
                        }
                    }
                }

                if (countFoundWords == 2) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
