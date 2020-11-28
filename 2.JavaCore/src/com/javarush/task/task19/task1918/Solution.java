package com.javarush.task.task19.task1918;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"span"};

        if (args.length < 1) return;

        String filePath; // = "f:\\10.txt";
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        StringBuilder fileStringBuilder = new StringBuilder();
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                fileStringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // ищем индексы всех открывающих тегов
        String fileAsString = fileStringBuilder.toString();
        List<Integer> listOfOpenTagIndex = new ArrayList<>();
        for (int i = 0; i < fileAsString.length(); ) {
            String openTag = "<" + args[0];
            int findIndex = fileAsString.indexOf(openTag, i);
            if (findIndex == -1) break;

            listOfOpenTagIndex.add(findIndex);
            i = findIndex + openTag.length();
        }

        // с каждого индекса ищем содержимое тега и выводим в консоль
        for (int openTagBeginIndex : listOfOpenTagIndex) {
            String tagLine = getTagLine(openTagBeginIndex, fileAsString, args[0]);
            if (tagLine != null) System.out.println(tagLine);
        }
    }

    private static String getTagLine(int searchFromIndex, String line, String tagName) {
        String openTag = "<" + tagName;
        String closeTag = "</" + tagName + ">";

        int openTagBeginIndex = line.indexOf(openTag, searchFromIndex);
        if (openTagBeginIndex != -1) {
            int openTagEndIndex = openTagBeginIndex + openTag.length();

            int tagLevel = 0;
            int index = openTagEndIndex;

            while (index < line.length()) {
                int nextOpenTagBeginIndex = line.indexOf(openTag, index);
                int nextCloseTagBeginIndex = line.indexOf(closeTag, index);

                if (nextOpenTagBeginIndex == -1 && nextCloseTagBeginIndex == -1)
                    return null;    // не нашли никаких тегов
                if (nextCloseTagBeginIndex == -1) return null;   // не нашли закрывающих тегов

                if ((nextOpenTagBeginIndex == -1) || (nextCloseTagBeginIndex < nextOpenTagBeginIndex)) {   // не нашли открвающего тего ИЛИ закрывающий раньше открывающего
                    if (tagLevel == 0) {
                        return line.substring(openTagBeginIndex, nextCloseTagBeginIndex + closeTag.length());
                    } else {
                        tagLevel--;
                        index = nextCloseTagBeginIndex + closeTag.length();
                    }
                } else if (nextOpenTagBeginIndex < nextCloseTagBeginIndex) {  // открывающий раньше закрывающего
//                    System.err.println("вложенные теги");
                    tagLevel++;
                    index = nextOpenTagBeginIndex + openTag.length();
                }
            }
        }

        return null; // не нашли открывающего тега
    }
}
