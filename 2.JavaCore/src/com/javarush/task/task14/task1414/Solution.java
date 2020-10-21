package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) {
        //ввести с консоли несколько ключей (строк), пункт 7
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = console.readLine();
                Movie movie = MovieFactory.getMovie(line);
                if (movie == null) break;
                System.out.println(movie.getClass().getSimpleName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MovieFactory {
        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3
    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
