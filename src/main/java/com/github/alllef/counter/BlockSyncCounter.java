package com.github.alllef.counter;

public class BlockSyncCounter extends Counter {
    @Override
    public void increment() {
        synchronized (this) {
            counter++;
        }
        System.out.println(counter);
    }

    @Override
    public void decrement() {
        synchronized (this) {
            counter--;
        }
        System.out.println(counter);

    }
}
