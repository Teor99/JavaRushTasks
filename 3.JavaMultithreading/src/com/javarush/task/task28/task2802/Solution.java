package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();

        Runnable r = () -> System.out.println(Thread.currentThread().getName());

        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolCounter = new AtomicInteger(1);
        private final int poolNumber;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public AmigoThreadFactory() {
            poolNumber = poolCounter.getAndIncrement();
        }

        @Override
        public Thread newThread(Runnable r) {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            String name = String.format("%s-pool-%d-thread-%d",
                    threadGroup.getName(),
                    poolNumber,
                    threadNumber.getAndIncrement());
            Thread thread = new Thread(threadGroup, r, name);
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }
}
