package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
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

        try (FileInputStream file1 = new FileInputStream(file1Path)) {
            int file1Size = file1.available();
            byte[] buffer = new byte[file1Size];
            byte[] bufferOutput = new byte[file1Size];
            file1.read(buffer);

            // reverse buffer
            for (int i = 0; i < buffer.length; i++) {
                bufferOutput[bufferOutput.length - 1 - i] = buffer[i];
            }

            try (FileOutputStream file2 = new FileOutputStream(file2Path)) {
                file2.write(bufferOutput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
