package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        String path;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            path = console.readLine();
            if (path.isEmpty()) return;
//            File f = new File(path);
            try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(path))) {
                while (true) {
                    String line = console.readLine();
                    outputFile.write(line);

                    if (line.equals("exit")) {
                        break;
                    } else {
                        outputFile.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
