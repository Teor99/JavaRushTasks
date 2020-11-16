package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String filePath;
            while (!(filePath = console.readLine()).equals("exit")) {
                new ReadThread(filePath).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try (BufferedInputStream file = new BufferedInputStream(new FileInputStream(fileName))) {
                int[] byteUsingTable = new int[256];
                int maxUsedCount = 0;
                int readedValue = -1;
                while ((readedValue = file.read()) != -1) {
                    byteUsingTable[readedValue]++;
                    if (byteUsingTable[readedValue] > maxUsedCount) maxUsedCount = byteUsingTable[readedValue];
                }

                for (int i = 0; i < byteUsingTable.length; i++) {
                    if (byteUsingTable[i] == maxUsedCount) {
                        synchronized (resultMap) {
                            resultMap.put(fileName, i);
                        }
                    }
                }

/*
                synchronized (resultMap) {
                    System.out.println(resultMap);
                }
*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
