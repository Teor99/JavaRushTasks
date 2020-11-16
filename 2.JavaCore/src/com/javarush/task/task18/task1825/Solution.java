package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
f:\movie.avi.part2
f:\movie.avi.part4
f:\movie.avi.part5
f:\movie.avi.part3
f:\movie.avi.part1

*/

/*
public class Solution {
    public static void main(String[] args) {
        String mainPath = null;
        List<Integer> partNumberList = new ArrayList<>();

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String pathLine;
            while (!(pathLine = console.readLine()).equals("end")) {
                String[] arr = pathLine.split(".part");
                if (mainPath == null) {
                    mainPath = arr[0];
                }

                if ( mainPath.equals(arr[0])) {
                    try {
                        partNumberList.add(Integer.parseInt(arr[1]));
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());
                    }
                } else {
                    System.err.printf("введенный путь \"%s\" отличается от последнего введенного \"%s\"\n", arr[0], mainPath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Collections.sort(partNumberList);

        try (BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream(mainPath))) {
            for (Integer partNumber : partNumberList) {
                try(FileInputStream inputFile = new FileInputStream(mainPath + ".part" + partNumber)) {
                    byte[] buffer = new byte[inputFile.available()];
                    inputFile.read(buffer);
                    outputFile.write(buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sort(List<String> pathList) {
        for (int i = 0; i < pathList.size(); i++) {
            for (int j = i+1; j < pathList.size(); j++) {

            }
        }
    }
} */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> files = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] parts1 = o1.split(".part");
                String[] parts2 = o2.split(".part");
                int number1 = Integer.parseInt(parts1[parts1.length - 1]);
                int number2 = Integer.parseInt(parts2[parts2.length - 1]);
                return number1 - number2;
            }
        });
        String outputFile = null;
        String readString;
        while (!(readString = reader.readLine()).equals("end")) {
            files.add(readString);
            if (outputFile == null) {
                int indexOfSuffix = readString.lastIndexOf(".part");
                outputFile = readString.substring(0, indexOfSuffix);
            }
        }
        if (outputFile == null) return;
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            for (String file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        int bytesRead = fileInputStream.read(buffer);
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}
