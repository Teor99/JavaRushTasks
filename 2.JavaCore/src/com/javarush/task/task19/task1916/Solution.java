package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
//        String origFilePath = "E:\\test\\1.txt";
//        String modifiedFilePath = "E:\\test\\2.txt";

//        String origFilePath = "E:\\test\\3.txt";
//        String modifiedFilePath = "E:\\test\\4.txt";

        String origFilePath = null;
        String modifiedFilePath = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            origFilePath = console.readLine();
            modifiedFilePath = console.readLine();
        }
        List<String> origLines = new ArrayList<>();
        List<String> modifiedLines = new ArrayList<>();

        readAllLines(origFilePath, origLines);
        readAllLines(modifiedFilePath, modifiedLines);

//        List<String> origLines = Files.readAllLines(Paths.get(origFilePath));
//        List<String> modifiedLines = Files.readAllLines(Paths.get(modifiedFilePath));

        compareLines(origLines, modifiedLines);
//        lines.forEach(System.out::println);
    }

    private static void readAllLines(String filePath, List<String> lines) throws IOException {
        try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = file.readLine()) != null) {
                lines.add(line);
            }
        }
    }

    private static void compareLines(List<String> origLines, List<String> modifiedLines) {

        int f1 = 0, f2 = 0;
        while (true) {
            if (isLineExist(f1, origLines)
                    && isLineExist(f2, modifiedLines)
                    && origLines.get(f1).equals(modifiedLines.get(f2))) {
                // SAME
                lines.add(new LineItem(Type.SAME, origLines.get(f1)));
                f1++;
                f2++;
            } else if (isLineExist(f1 + 1, origLines)
                    && isLineExist(f2, modifiedLines)
                    && origLines.get(f1 + 1).equals(modifiedLines.get(f2))) {
                // REMOVED
                lines.add(new LineItem(Type.REMOVED, origLines.get(f1)));
                f1++;
            } else if (isLineExist(f1, origLines)
                    && isLineExist(f2 + 1, modifiedLines)
                    && origLines.get(f1).equals(modifiedLines.get(f2 + 1))) {
                // ADDED
                lines.add(new LineItem(Type.ADDED, modifiedLines.get(f2)));
                f2++;
            } else if (isLineExist(f1, origLines) && !isLineExist(f2, modifiedLines)) {
                // modified file end
                lines.add(new LineItem(Type.REMOVED, origLines.get(f1)));
                f1++;
            } else if (!isLineExist(f1, origLines) && isLineExist(f2, modifiedLines)) {
                // orig file end
                lines.add(new LineItem(Type.ADDED, modifiedLines.get(f2)));
                f2++;
            } else if (!isLineExist(f1, origLines) && !isLineExist(f2, modifiedLines)) {
                // both file end
                break;
            } else {
                throw new IllegalArgumentException("orig line: " + f1 + " modified line:" + f2);
            }
        }
    }

    private static boolean isLineExist(int index, List<String> lines) {
        return index >= 0 && index < lines.size();
    }
/*
    private static boolean isLastElement(int index, List<String> lines) {
        return index == lines.size() - 1;
    }*/

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + " " + line;
        }
    }
}
