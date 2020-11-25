package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String filePath;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = file.readLine()) != null) {
                StringBuilder resultLine = new StringBuilder();
//                resultLine.reverse();
                for (int i = line.length() - 1; i >= 0; i--) {
                    resultLine.append(line.charAt(i));
                }
                System.out.println(resultLine.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
