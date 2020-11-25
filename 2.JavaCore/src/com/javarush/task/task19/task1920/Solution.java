package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"f:\\4.txt"};

        if (args.length < 1) return;

        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> map = new TreeMap<>();
            String line;
            while ((line = file.readLine()) != null) {
                String[] splitLine = line.split(" ");
                String lastName = splitLine[0];
                double value = 0.0;
                try {
                    value = Double.parseDouble(splitLine[1]);
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                    continue;
                }

                if (map.containsKey(lastName)) {
                    value += map.get(lastName);
                }

                map.put(lastName, value);
            }

            double maxPay = Double.MIN_VALUE;
            for (Map.Entry<String, Double> pair : map.entrySet()) {
                maxPay = Math.max(maxPay, pair.getValue());
            }

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                if (pair.getValue() == maxPay) {
                    System.out.println(pair.getKey());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
