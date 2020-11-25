package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double time = Double.parseDouble(reader.readLine());
        time = time % 5;
        if ( 0 <= time & time < 3) {
            System.out.println("зелёный");
        } else if (3 <= time & time < 4){
            System.out.println("жёлтый");
        } else if (4 <= time & time < 5){
            System.out.println("красный");
        }
    }
}*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double t = Double.parseDouble(s);


        for (int i = 0; i <= 60; i += 5) {

            if (t >= (0 + i) && t < (3 + i)) System.out.println("зелёный");
            else if (t >= (3 + i) && t < (4 + i)) System.out.println("жёлтый");
            else if (t >= (4 + i) && t < (5 + i)) System.out.println("красный");


        }


    }
}

/*

//package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

*/
/*
Сортировка четных чисел из файла

Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа, считанные из файла, отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла — FileInputStream.
*//*


public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename;

        filename = reader.readLine();

        //   System.out.println("read ok");
        ArrayList<Integer> integers = new ArrayList<>(); // array
        FileInputStream filestr = new FileInputStream(filename);
        DataInputStream inStream = new DataInputStream(filestr);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        bufferedReader.readLine();

        while (inStream.available() > 0)
        {
            int data = inStream.readInt(); //читаем один int из потока для чтения
            if (data%2==0) {integers.add(data);}
        }

        filestr.close(); //закрываем потоки

        // сортировка



        Collections.sort(integers);

        for (int s:integers
        ) {
            System.out.println(s);
        }
    }



}

*/
