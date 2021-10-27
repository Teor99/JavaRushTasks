package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

//        args = new String[]{"D:\\java.pdf", "D:\\java.zip.001", "D:\\java.zip.002", "D:\\java.zip.003", "D:\\java.zip.004", "D:\\java.zip.005", "D:\\java.zip.006", "D:\\java.zip.007", "D:\\java.zip.008", "D:\\java.zip.009", "D:\\java.zip.010", "D:\\java.zip.011"};

        Arrays.sort(args, 1, args.length);

        Vector<BufferedInputStream> zipParts = new Vector<>();
        for (int i = 1; i < args.length; i++) {
            zipParts.add(new BufferedInputStream(new FileInputStream(args[i])));
        }

        try (ZipInputStream zipFile = new ZipInputStream(new SequenceInputStream(zipParts.elements()))) {
            ZipEntry ze = zipFile.getNextEntry();
            if (ze != null) {
                try (BufferedOutputStream resultFile = new BufferedOutputStream(new FileOutputStream(args[0]))) {
                    // unzip data to result file
                    byte[] buffer = new byte[8192];
                    int readed = 0;
                    while ((readed = zipFile.read(buffer)) != -1) {
                        resultFile.write(buffer, 0, readed);
                    }
                }
            }
        }
    }
}
