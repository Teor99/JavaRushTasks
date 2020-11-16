package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файлы и исключения
*/

public class Solution {
    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String path = null;
                try {
                    path = console.readLine();
                    MyFileReaderThread thread = new MyFileReaderThread(path);
                    thread.start();
                    threads.add(thread);
                } catch (FileNotFoundException e) {
                    System.out.println(path);

                    break;
                }
            }

            for (Thread thread : threads) {
                thread.interrupt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyFileReaderThread extends Thread {
        private FileInputStream file;

        public MyFileReaderThread(String filePath) throws FileNotFoundException {
            file = new FileInputStream(filePath);
        }

        @Override
        public void run() {
            while (!isInterrupted()) {

            }
        }

        @Override
        public void interrupt() {
            super.interrupt();

            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
