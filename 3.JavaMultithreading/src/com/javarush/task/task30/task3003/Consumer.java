package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            return;
        }

        while (true) {
            try {
                ShareItem item = queue.take();
                System.out.format("Processing %s" + System.lineSeparator(), item.toString());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
