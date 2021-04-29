package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method

        URL url = new URL(urlString);
        String fileName = Paths.get(url.getFile()).getFileName().toString();
        Path tempFile = Files.createTempFile(null, null);
        try (InputStream in = url.openStream()) {
            Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
            if (Files.notExists(downloadDirectory)) {
                Files.createDirectory(downloadDirectory);
            }
            Path downloadLocalPath = Paths.get(downloadDirectory.toString() + File.separator + fileName);
            Files.deleteIfExists(downloadLocalPath);

            return Files.move(tempFile, downloadLocalPath);
        }
    }
}
