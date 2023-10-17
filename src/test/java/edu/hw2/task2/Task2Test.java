package edu.hw2.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Task2Test {

    @Test
    void testRectangleArea() {
        GeometricShape rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(3);
        assertThat(rectangle.area()).isEqualTo(15.0);
    }

    @Test
    void testSquareArea() {
        GeometricShape square = new Square();
        square.setWidth(4);
        square.setHeight(4);
        assertThat(square.area()).isEqualTo(16.0);
    }

    @Test
    void testSquareAreaWithTryingSetDiffSides() {
        GeometricShape square = new Square();
        square.setWidth(4);
        square.setHeight(5);
        assertThat(square.area()).isEqualTo(25.0);
    }

    @Test
    void testBothShapes() {
        GeometricShape rectangle = new Rectangle();
        GeometricShape square = new Square();
        rectangle.setWidth(5);
        rectangle.setHeight(3);
        square.setWidth(4);
        square.setHeight(4);
        assertThat(rectangle.area()).isEqualTo(15.0);
        assertThat(square.area()).isEqualTo(16.0);
    }

}
