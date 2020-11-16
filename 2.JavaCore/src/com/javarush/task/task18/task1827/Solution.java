package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) {
//        args = new String[]{"-c", "Шорты пляжные красные", "150.00", "30"};

        if (args.length != 4) return;
        if (!args[0].equals("-c")) return;

        String filePath;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int maxId = 0;
        try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = file.readLine()) != null ) {
                int id = 0;
                try {
                    id = Integer.parseInt(line.substring(0, 8).trim());
                    maxId = Math.max(maxId, id);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = packStringToSize("" + ++maxId, 8);
        result += packStringToSize(args[1], 30);
        result += packStringToSize(args[2], 8);
        result += packStringToSize(args[3], 4);

        try (BufferedWriter file = new BufferedWriter(new FileWriter(filePath, true))) {
            file.write("\n");
            file.write(result);
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
