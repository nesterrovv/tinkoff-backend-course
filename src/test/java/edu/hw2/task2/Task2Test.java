package edu.hw2.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    private static Arguments[] getShapes() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("getShapes")
    @DisplayName("Test rectangle area calculation")
    public void testRectangleArea(Rectangle rectangle) {
        Rectangle result = rectangle
            .createWithWidth(20.0)
            .createWithHeight(10.0);

        assertThat(result.area()).isEqualTo(200.0);
    }

}
