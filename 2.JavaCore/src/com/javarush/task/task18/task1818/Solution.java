package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
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

        try (BufferedInputStream file2 = new BufferedInputStream(new FileInputStream(file2Path))) {
//            file2.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write file2 -> file1
        try (FileInputStream file2 = new FileInputStream(file2Path)) {
            int file2Size = file2.available();
            byte[] buffer = new byte[file2Size];
            file2.read(buffer);

            try (FileOutputStream file1 = new FileOutputStream(file1Path)) {
                file1.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // append file3 -> file1
        try (FileInputStream file3 = new FileInputStream(file3Path)) {
            int file3Size = file3.available();
            byte[] buffer = new byte[file3Size];
            file3.read(buffer);

            try (FileOutputStream file1 = new FileOutputStream(file1Path, true)) {
                file1.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}