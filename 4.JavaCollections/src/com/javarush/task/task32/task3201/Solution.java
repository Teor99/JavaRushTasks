package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
//        args = new String[]{"1", "50", "text_to_input"};
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            int inputPos = Integer.parseInt(args[1]);
//            raf.seek(inputPos);
            raf.seek(inputPos < raf.length() ? inputPos : (int) raf.length());
            raf.write(args[2].getBytes());
        }
    }
}