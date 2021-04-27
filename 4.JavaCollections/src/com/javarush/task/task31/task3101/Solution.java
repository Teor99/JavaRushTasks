package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[]{"D:\\TORRENTS", "D:\\files.txt"};
//        args = new String[]{"D:\\TORRENTS", "D:\\TORRENTS\\core_java_2\\CoreJavaBook\\v1ch7\\FontTest\\files.txt"};
        File dirForScan = new File(args[0]);
        File sourceOutputFile = new File(args[1]);

        String outputFileParentPath = sourceOutputFile.getParentFile().getCanonicalPath();
        if (!outputFileParentPath.endsWith(File.separator)) {
            outputFileParentPath += File.separator;
        }

        File newOutputFile = new File( outputFileParentPath + "allFilesContent.txt");
        if (FileUtils.isExist(sourceOutputFile)) {
            FileUtils.renameFile(sourceOutputFile, newOutputFile);
        }

        List<File> list = getFileSetFromDir(dirForScan);

        list.sort(new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return f1.getName().compareTo(f2.getName());
            }
        });

//        list.forEach(System.out::println);

        try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(newOutputFile))) {
            for (File file : list) {
                try (BufferedReader inputFile = new BufferedReader(new FileReader(file))) {
                    while (inputFile.ready()) {
                        outputFile.write(inputFile.read());
                    }
                }

                outputFile.write(System.lineSeparator());
            }
        }
    }

    private static List<File> getFileSetFromDir(File dirForScan) {
        List<File> resultList = new ArrayList<>();

        // empty?
        File[] files = dirForScan.listFiles();
        if (files == null || files.length == 0) {
            return resultList;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // recursive scan child directory
                List<File> tempList = getFileSetFromDir(file);
                resultList.addAll(tempList);
            } else if (file.length() <= 50) {
                resultList.add(file);
            }
        }

        return resultList;
    }
}