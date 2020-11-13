package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
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
                arr[asIndex] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                result.append(i).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
}
