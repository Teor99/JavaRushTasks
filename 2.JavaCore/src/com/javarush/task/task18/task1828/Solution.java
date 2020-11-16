package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"-u", "19846", "Шорты пляжные красные", "150.00", "30"};
//        args = new String[]{"-d", "19846"};
//        args = new String[]{"-d", "88888888"};

        if (args.length < 1) return;
        switch (args[0]) {
            case "-u":
                if (args.length != 5) return;
                break;
            case "-d":
                if (args.length != 2) return;
                break;
            default:
                return;
        }

        String filePath;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<String> lines = new ArrayList<>();

        try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = file.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter file = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                switch (args[0]) {
                    case "-u":
                        if (args[1].equals(line.substring(0, 8).trim())) {
                            String updatedLine = packStringToSize(args[1],8);
                            updatedLine += packStringToSize(args[2],30);
                            updatedLine += packStringToSize(args[3],8);
                            updatedLine += packStringToSize(args[4],4);
                            file.write(updatedLine);
                            file.write("\n");
                            continue;
                        }
                        break;
                    case "-d":
                        if (args[1].equals(line.substring(0, 8).trim())) {
                            continue;
                        }
                        break;
                }

                file.write(line);
                file.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String packStringToSize(String str, int size) {
        if (str.length() > size) {
            return str.substring(0, size);
        } else if (str.length() < size) {
            StringBuilder result = new StringBuilder(str);
            while (result.length() != size) {
                result.append(" ");
            }
            return result.toString();
        }

        return str;
    }
}
