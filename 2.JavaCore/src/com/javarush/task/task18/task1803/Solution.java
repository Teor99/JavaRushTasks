package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.ArrayList;

/* 
Самые частые байты
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

        int[] arr = new int[256];
        int maxUsage = 0;
        try (FileInputStream inputFile = new FileInputStream(filePath)) {
            while (inputFile.available() > 0) {
                int asIndex = inputFile.read();
                arr[asIndex]++;
                maxUsage = Math.max(maxUsage, arr[asIndex]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxUsage) {
                result.append(i).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
}
