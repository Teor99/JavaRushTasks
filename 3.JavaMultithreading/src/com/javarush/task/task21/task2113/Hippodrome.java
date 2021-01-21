package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        List<Horse> tmpHorses = new ArrayList<>();
        tmpHorses.add(new Horse("Кузя", 3, 0));
        tmpHorses.add(new Horse("Вихрь", 3, 0));
        tmpHorses.add(new Horse("Тайфун", 3, 0));

        game = new Hippodrome(tmpHorses);
        game.run();
        game.printWinner();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public void print() {
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        int winnerIndex = -1;
        double maxDistance = Double.MIN_VALUE;
        for (int i = 0; i < horses.size(); i++) {
            Horse currentHorse = horses.get(i);
            if (currentHorse.getDistance() > maxDistance) {
                winnerIndex = i;
                maxDistance = currentHorse.getDistance();
            }
        }

        if (winnerIndex == -1) return null;

        return horses.get(winnerIndex);
    }

    public void printWinner() {
        System.out.printf("Winner is %s!\n", getWinner().getName());
    }
}
