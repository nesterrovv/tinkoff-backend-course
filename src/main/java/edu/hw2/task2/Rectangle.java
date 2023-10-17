package edu.hw2.task2;

public class Rectangle implements GeometricShape {

    private int width;
    private int height;

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

}
