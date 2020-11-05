package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new InfiniteThread());
        threads.add(new CanBeInterruptedThread());
        threads.add(new HalfSecondThread());
        threads.add(new ImplementsMessageThread());
        threads.add(new CalcThread());
    }

    public static void main(String[] args) throws InterruptedException {
//        threads.get(4).start();
    }

    private static class InfiniteThread extends Thread {

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    private static class CanBeInterruptedThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    private static class HalfSecondThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ImplementsMessageThread extends Thread implements Message {
        private boolean isStopped = false;

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    isStopped = true;
                }
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }


    }

    private static class CalcThread extends Thread {

        @Override
        public void run() {
            try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
                long result = 0;
                while (true) {
                    String line = console.readLine();

                    if (line.equals("N")) {
                        System.out.println(result);
                        break;
                    } else {
                        try {
                            result += Integer.parseInt(line);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}