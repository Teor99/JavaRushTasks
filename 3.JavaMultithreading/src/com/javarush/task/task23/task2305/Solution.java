package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {

    }

    public static Solution[] getTwoSolutions() {
        Solution[] arr = new Solution[2];

        arr[0] = new Solution();
        arr[0].innerClasses[0] = arr[0].new InnerClass();
        arr[0].innerClasses[1] = arr[0].new InnerClass();

        arr[1] = new Solution();
        arr[1].innerClasses[0] = arr[1].new InnerClass();
        arr[1].innerClasses[1] = arr[1].new InnerClass();


        return arr;
    }

    public static void main(String[] args) {

    }
}