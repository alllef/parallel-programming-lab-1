package com.github.alllef.counter;

public abstract class Counter {
    protected int counter = 0;

    public abstract void increment();

    public abstract void decrement();
}
