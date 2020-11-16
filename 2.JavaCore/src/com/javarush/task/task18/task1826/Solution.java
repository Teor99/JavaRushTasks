package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"-e", "f:\\1.png", "f:\\2.png"};
//        args = new String[]{"-d", "f:\\2.png", "f:\\3.png"};

        if (args.length != 3) return;

        switch (args[0]) {
            case "-e":
                cryptFunc(args, true);
                break;
            case "-d":
                cryptFunc(args, false);
                break;
            default:
                System.out.println("Unknown parameter: " + args[0]);
        }
    }

    private static void cryptFunc(String[] args, boolean isToEncrypt) {
        try (FileInputStream inputFile = new FileInputStream(args[1])) {
            int inputFileSize = inputFile.available();
            byte[] buffer = new byte[inputFileSize];
            inputFile.read(buffer);
            if (isToEncrypt) {
                encrypt(buffer);
            } else {
                decrypt(buffer);
            }

            try (FileOutputStream outputFile = new FileOutputStream(args[2])) {
                outputFile.write(buffer);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decrypt(byte[] buffer) {
        for (int i = 0, incValue = 1; i < buffer.length; i++, incValue++) {
            if (incValue == 5) incValue = 1;

            buffer[i] += incValue;
        }
    }

    private static void encrypt(byte[] buffer) {
        for (int i = 0, decValue = 1; i < buffer.length; i++, decValue++) {
            if (decValue == 5) decValue = 1;

            buffer[i] -= decValue;
        }
    }
}
