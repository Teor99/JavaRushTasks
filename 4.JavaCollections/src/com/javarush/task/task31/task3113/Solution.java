package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String dirPathLine = console.readLine();
            Path dirPath = Paths.get(dirPathLine);
            if (!Files.isDirectory(dirPath)) {
                System.out.println(dirPathLine + " - не папка");
                return;
            }

            class MyFileVisitor implements FileVisitor<Path> {
                private int dirCount = 0;
                private int fileCount = 0;
                private long totalUsedSpace = 0;

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    dirCount++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCount++;
                    totalUsedSpace += attrs.size();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                public int getDirCount() {
                    return dirCount == 0 ? dirCount : dirCount - 1;
                }

                public int getFileCount() {
                    return fileCount;
                }

                public long getTotalUsedSpace() {
                    return totalUsedSpace;
                }
            }

            MyFileVisitor mfv = new MyFileVisitor();
            Files.walkFileTree(dirPath, mfv);

            System.out.println("Всего папок - " + mfv.getDirCount());
            System.out.println("Всего файлов - " + mfv.getFileCount());
            System.out.println("Общий размер - " + mfv.getTotalUsedSpace());
        }
    }
}
