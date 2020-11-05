package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = console.readLine();
            secondFileName = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private String fileContent = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void run() {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fullFileName))) {
                StringBuilder stringBuilder = new StringBuilder();
                while (fileReader.ready()) {
                    String line = fileReader.readLine();
                    stringBuilder.append(line);
                    stringBuilder.append(" ");
                }

                fileContent = stringBuilder.toString().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
