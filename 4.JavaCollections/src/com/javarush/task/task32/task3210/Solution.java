package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
//        args = new String[]{"1", "50", "text_to_input"};
        boolean isSameString = false;

        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long inputPos = Long.parseLong(args[1]);
            if (inputPos + args[2].length() <= raf.length()) {
                raf.seek(inputPos);
                byte[] buffer = new byte[args[2].length()];
                raf.read(buffer, 0, buffer.length);
                String readedLine = new String(buffer);
                isSameString = readedLine.equals(args[2]);
            }

            raf.seek(raf.length());
            raf.write(Boolean.toString(isSameString).getBytes(StandardCharsets.UTF_8));
        }
    }
}
