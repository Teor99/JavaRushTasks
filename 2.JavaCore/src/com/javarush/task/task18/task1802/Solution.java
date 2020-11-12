package com.javarush.task.task18.task1802;

import java.io.*;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args){
        String path = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            path = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int min = Integer.MAX_VALUE;
            while (fileInputStream.available() > 0) {
                min = Math.min(min, fileInputStream.read());
            }
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
