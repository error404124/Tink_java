package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle(3, 3)),
            Arguments.of(new Square(3))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setHeight(10);
        rect = rect.setWidth(20);
        assertThat(rect.area()).isEqualTo(200.0);
    }
}
