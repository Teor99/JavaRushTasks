package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread loggingThread = null;
    private State lastState = null;

    public LoggingStateThread(Thread loggingThread) {
        this.loggingThread = loggingThread;
    }

    @Override
    public void run() {
        while (true) {
            State state = loggingThread.getState();
            if (lastState != state ) {
                System.out.println(state);
                lastState = state;
            }

            if (state == State.TERMINATED) break;
        }
    }
}
