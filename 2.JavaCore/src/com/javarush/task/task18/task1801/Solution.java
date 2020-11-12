package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимальный байт
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
            int maxByte = 0;
            while (fileInputStream.available() > 0) {
                maxByte = Math.max(maxByte, fileInputStream.read());
            }
            System.out.println(maxByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}