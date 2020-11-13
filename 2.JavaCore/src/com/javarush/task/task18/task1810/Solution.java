package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String filePath = console.readLine();
                try (FileInputStream file = new FileInputStream(filePath)) {
                    if (file.available() < 1000) {
                        throw new DownloadException();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}