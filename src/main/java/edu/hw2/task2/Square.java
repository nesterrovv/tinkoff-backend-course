package edu.hw2.task2;

public class Square extends Rectangle {

    public Square() {}

    public Square(double size) {
        super(size, size);
    }

    public final Square createWithSize(double size) {
        return new Square(size);
    }

}
