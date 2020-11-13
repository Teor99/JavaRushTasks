package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
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

        try (FileInputStream file = new FileInputStream(filePath)) {
            int count = 0;
            while (file.available() > 0) {
                char symbol = (char) file.read();
                if (symbol == ',') {
                    count++;
                }
            }

            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
