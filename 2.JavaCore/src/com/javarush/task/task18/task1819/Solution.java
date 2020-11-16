package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        String file1Path;
        String file2Path;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            file1Path = console.readLine();
            file2Path = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        byte[] file1DataBuffer = null;
        // file1 save to buffer
        try (FileInputStream file1 = new FileInputStream(file1Path)) {
            file1DataBuffer = new byte[file1.available()];
            file1.read(file1DataBuffer);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // file2 overwrite to file1 + append file1 buffer
        try (FileInputStream file2 = new FileInputStream(file2Path)) {
            byte[] file2DataBuffer = new byte[file2.available()];
            file2.read(file2DataBuffer);

            try (FileOutputStream file1 = new FileOutputStream(file1Path)) {
                file1.write(file2DataBuffer);
                file1.write(file1DataBuffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
