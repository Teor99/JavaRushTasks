package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"f:\\1.png"};

        if (args.length < 1) return;

        try (BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(args[0]))) {
            int count = 0;
            int readedValue;
            while ((readedValue = inputFile.read()) != -1) {
                char symbol = (char) readedValue;
                if (symbol >= 'A' && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z') {
                    count++;
                }
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
