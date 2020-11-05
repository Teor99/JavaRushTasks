package com.javarush.task.task16.task1626;

/* 
Создание по образцу
*/

import java.util.Date;

public class Solution {
    public static int number = 5;
//    private static volatile long begin = new Date().getTime();

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable {
        //Add your code here - добавь код тут
        private int countIndexUp = 1;

        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    System.out.println(toString());
//                    System.err.println(new Date().getTime() - begin);
                    countIndexUp += 1;
                    if (countIndexUp == Solution.number + 1) return;
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }


    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
//                    System.err.println(new Date().getTime() - begin);
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
