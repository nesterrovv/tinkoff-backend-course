package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public final class MultithreadCounter {

    private AtomicInteger counter;

    public MultithreadCounter(int initialValue) {
        counter = new AtomicInteger(initialValue);
    }

    public int getValue() {
        return counter.get();
    }

    public void increment() {
        counter.incrementAndGet();
    }

}
