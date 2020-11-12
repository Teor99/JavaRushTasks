package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String firstFilePath;
        String secondFilePath;

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            firstFilePath = console.readLine();
            secondFilePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedReader firstFile = new BufferedReader(new FileReader(firstFilePath))) {
            while (firstFile.ready()) {
                allLines.add(firstFile.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        try (BufferedReader secondFile = new BufferedReader(new FileReader(secondFilePath))) {
            while (secondFile.ready()) {
                forRemoveLines.add(secondFile.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
//            allLines.removeAll(allLines);
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
