package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private final int value;

    public BinaryRepresentationTask(int value) {
        this.value = value;
    }

    @Override
    protected String compute() {
        int a = value % 2;
        int b = value / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return new BinaryRepresentationTask(b).fork().join() + result;
        }

        return result;
    }
}
