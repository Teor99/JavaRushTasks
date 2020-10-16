package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String path = console.readLine();
            if (path.isEmpty()) return;

            List<Integer> list = new ArrayList<>();

            try (FileInputStream fis = new FileInputStream(path)) {
                Scanner file = new Scanner(fis);
                while (file.hasNextInt()) {
                    list.add(file.nextInt());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }

            Collections.sort(list);

            for (Integer value : list) {
                if (value % 2 == 0) {
                    System.out.println(value);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
