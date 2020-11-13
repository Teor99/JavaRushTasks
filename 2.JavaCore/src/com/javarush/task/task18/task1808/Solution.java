package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        String file1Path;
        String file2Path;
        String file3Path;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            file1Path = console.readLine();
            file2Path = console.readLine();
            file3Path = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (FileInputStream file1 = new FileInputStream(file1Path)) {
            int file1Size = file1.available();
            int file1BigHalfSize = file1Size - file1Size / 2;
            byte[] buffer = new byte[file1Size];
            file1.read(buffer);

            try (FileOutputStream file2 = new FileOutputStream(file2Path)) {
                file2.write(buffer, 0 , file1BigHalfSize);
            }

            try (FileOutputStream file3 = new FileOutputStream(file3Path)) {
                file3.write(buffer, file1BigHalfSize, buffer.length - file1BigHalfSize);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
