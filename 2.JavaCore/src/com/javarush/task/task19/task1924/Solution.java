package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        String filePath;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

//        filePath = "f:\\5.txt";

        try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("\\b\\d+\\b", Pattern.UNICODE_CHARACTER_CLASS);
            while ((line = file.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String keyNumberLine = line.substring(matcher.start(), matcher.end());
                    int keyNumber;
                    try {
                        keyNumber = Integer.parseInt(keyNumberLine);
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());
                        continue;
                    }

                    if (map.containsKey(keyNumber)) {
                        line = line.substring(0, matcher.start()) + map.get(keyNumber) + line.substring(matcher.end());
                        matcher = pattern.matcher(line);
                    }
                }

                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
