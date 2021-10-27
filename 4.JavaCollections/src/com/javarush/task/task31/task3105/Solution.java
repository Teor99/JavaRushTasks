package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[]{"D:\\logo.png", "D:\\java.zip"};

        Map<String, byte[]> map = getZipEntryListFromFile(args[1]);
        writeZipEntryListToFileWithFileUpdate(map, args[1], args[0]);
    }

    private static Map<String, byte[]> getZipEntryListFromFile(String filePath) throws IOException {

        Map<String, byte[]> resultMap = new HashMap<>();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(filePath))) {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    byte[] buffer = new byte[8192];
                    int byteCount = 0;
                    while ((byteCount = zis.read(buffer)) != -1) {
                        baos.write(buffer, 0, byteCount);
                    }
                    resultMap.put(ze.getName(), baos.toByteArray());
                }
            }
        }

        return resultMap;
    }

    private static void writeZipEntryListToFileWithFileUpdate(Map<String, byte[]> map, String zipFilePath, String fileToCompressPath) throws IOException {
        String newZipEntryName = Paths.get(fileToCompressPath).toFile().getName();
        Files.deleteIfExists(Paths.get(zipFilePath));
        boolean isFileBeenUpdated = false;

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                zos.putNextEntry(new ZipEntry(entry.getKey()));
                if (entry.getKey().equals(newZipEntryName)) {
                    // write new file content
                    Files.copy(Paths.get(fileToCompressPath), zos);
                    isFileBeenUpdated = true;
                } else {
                    // write old content
                    zos.write(entry.getValue());
                }
            }

            // same file not found
            if (!isFileBeenUpdated) {
                zos.putNextEntry(new ZipEntry(newZipEntryName));
                Files.copy(Paths.get(fileToCompressPath), zos);
            }
        }
    }
}
