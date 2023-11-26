package edu.hw7.task1;

public final class SingleThreadCounter {

    private int value;

    public SingleThreadCounter(int initialValue) {
        this.value = initialValue;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value += 1;
    }

}
