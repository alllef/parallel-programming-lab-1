package com.github.alllef.counter;

public class MethodSyncCounter extends Counter {

    @Override
    public synchronized void increment() {
        counter++;
        System.out.println(counter);
    }

    @Override
    public synchronized void decrement() {
        counter--;
        System.out.println(counter);
    }
}
