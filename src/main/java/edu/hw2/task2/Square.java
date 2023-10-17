package edu.hw2.task2;

public class Square implements GeometricShape {

    private int side;

    @Override
    public void setWidth(int width) {
        this.side = width;
    }

    @Override
    public void setHeight(int height) {
        this.side = height;
    }

    @Override
    public double area() {
        return side * side;
    }

}
