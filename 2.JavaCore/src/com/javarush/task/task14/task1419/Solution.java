package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            String s = null;
            s.isEmpty();
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[2];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            int i = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            System.out.println("abc".charAt(10));
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            exceptions.add(e);
        }

        try {
            throw new SecurityException();
        } catch (SecurityException e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalThreadStateException();
        } catch (IllegalThreadStateException e) {
            exceptions.add(e);
        }
    }
}
