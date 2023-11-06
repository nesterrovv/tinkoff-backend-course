package edu.hw2.task2;

public class Rectangle {
    private final double width;
    private final double height;

    public Rectangle() {
        this(0.0, 0.0);
    }

    public Rectangle(double width, double height) {
        if (width < 0.0 || height < 0.0) {
            throw new IllegalArgumentException("Width and height must be positive values.");
        }

        this.width = width;
        this.height = height;
    }

    public final Rectangle createWithWidth(double width) {
        return new Rectangle(width, this.height);
    }

    public final Rectangle createWithHeight(double height) {
        return new Rectangle(this.width, height);
    }

    public final double getWidth() {
        return width;
    }

    public final double getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }

}
