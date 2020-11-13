package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
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
        try (FileInputStream inputFile = new FileInputStream(filePath)) {
            while (inputFile.available() > 0) {
                int asIndex = inputFile.read();
                arr[asIndex]++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        int minUsage = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && minUsage > arr[i]) {
                minUsage = arr[i];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minUsage) {
                result.append(i).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
}
