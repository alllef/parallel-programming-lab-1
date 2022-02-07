package com.github.alllef.counter;

public class CounterMain {
    public static void startCounterThreads(Counter counter) {
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                counter.increment();
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                counter.decrement();
        });
        incrementThread.start();
        decrementThread.start();
    }

    public static void main(String[] args) {
        Counter counter = new MethodSyncCounter();
        startCounterThreads(counter);
    }
}
