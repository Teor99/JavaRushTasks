package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        args = new String[]{"D:\\java.pdf", "D:\\java.zip.001", "D:\\java.zip.002", "D:\\java.zip.003", "D:\\java.zip.004", "D:\\java.zip.005", "D:\\java.zip.006", "D:\\java.zip.007", "D:\\java.zip.008", "D:\\java.zip.009", "D:\\java.zip.010", "D:\\java.zip.011"};

        Path zipFilePath = Files.createTempFile(null, null);
        try (BufferedOutputStream tempFile = new BufferedOutputStream(new FileOutputStream(zipFilePath.toFile()))) {
            for (int i = 1; i < args.length; i++) {
                try (BufferedInputStream zipPartFile = new BufferedInputStream(new FileInputStream(args[i]))) {
                byte[] buffer = new byte[4096];
                int readed = 0;
                while ((readed = zipPartFile.read(buffer)) != -1) {
                    tempFile.write(buffer, 0 , readed);
                }
//                    tempFile.write(zipPartFile.readAllBytes());
                }
            }
        }

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath.toFile()))) {
                ZipEntry ze = zis.getNextEntry();
                byte[] buffer = new byte[4096];
                int readed = 0;
                while ((readed = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0 , readed);
                }
//                baos.write(zis.readAllBytes());
            }

            try (BufferedOutputStream resultFile = new BufferedOutputStream(new FileOutputStream(args[0]))) {
                baos.writeTo(resultFile);
            }
        }
    }
}
