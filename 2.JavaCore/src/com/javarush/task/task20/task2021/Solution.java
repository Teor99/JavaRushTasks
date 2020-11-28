package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("Не сегодня!");
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new NotSerializableException("Не сегодня!");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        SubSolution subSolution = new SubSolution();
        outputStream.writeObject(subSolution);

        fileOutput.close();
        outputStream.close();

        //load
        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        SubSolution loadedObject = (SubSolution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(subSolution.equals(loadedObject));*/

    }
}
