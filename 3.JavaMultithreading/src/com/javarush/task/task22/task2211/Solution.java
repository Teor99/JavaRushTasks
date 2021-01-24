package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[]{"f:/12.txt", "f:/13.txt"};

        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(args[0]), Charset.forName("Windows-1251"));
             OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8)) {
            char[] cbuf = new char[1024];
            while (inputFile.ready()) {
                int readed = inputFile.read(cbuf);
                outputFile.write(cbuf, 0, readed);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
