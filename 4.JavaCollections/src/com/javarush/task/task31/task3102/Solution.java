package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> resultList = new ArrayList<>();
        Queue<File> dirQueue = new ArrayDeque<>();
        dirQueue.add(new File(root));

        while (!dirQueue.isEmpty()) {
            File currentDir = dirQueue.poll();
            File[] files = currentDir.listFiles();
            if (files == null || files.length == 0) continue;

            for (File file : files) {
                if (file.isDirectory()) {
                    dirQueue.add(file);
                } else {
                    resultList.add(file.getAbsolutePath());
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) throws IOException {
        getFileTree("D:\\TORRENTS").forEach(System.out::println);
    }
}
