package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] resultIP = new byte[4];
        for (int i = 0; i < 4; i++) {
            resultIP[i] = (byte) (ip[i] & mask[i]);
        }

        return resultIP;
    }

    public static void print(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            StringBuilder line = new StringBuilder(Integer.toBinaryString(b));
            if (line.length() > 8) {
                line = new StringBuilder(line.substring(line.length() - 8));
            } else if (line.length() < 8) {
                while (line.length() < 8) {
                    line.insert(0, "0");
                }
            }
            result.append(line).append(" ");
        }


        System.out.println(result.toString().trim());

/*
        for (String line : result.toString().trim().split(" ")) {
            System.err.print(Integer.parseInt(line, 2));
            System.err.print(".");
        }
        System.err.println();
*/
    }
}
