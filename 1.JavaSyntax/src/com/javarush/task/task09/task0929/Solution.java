package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = null;
        InputStream fileInputStream = null;

        // 2 попытки на открытие файла
        // если после 2х попыток "Файл не существует." - выход из программы
        int tryCount = 2;
        do {
            sourceFileName = reader.readLine();
            try {
                fileInputStream = getInputStream(sourceFileName);
                tryCount = 0;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не существует.");
                tryCount--;
                if (tryCount == 0) return;
            }
        } while (tryCount > 0);


        String destinationFileName = reader.readLine();
        OutputStream fileOutputStream = getOutputStream(destinationFileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

