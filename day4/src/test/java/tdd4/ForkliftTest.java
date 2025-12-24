package tdd4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForkliftTest {
    private Forklift sut;

    @BeforeEach
    void setUp() {
        sut = new Forklift();
    }

    @Test
    void testIsAccessibleScroll() {
        // Arrange
        final String[][] grid = new String[][]{{".", "@", "."}, {"@", "@", "@"}, {".", ".", "."}};
        final Point point = new Point(1, 1);

        // Act
        boolean result = sut.isAccessibleScroll(point, grid);

        // Assert
        assertTrue(result);
    }

    @Test
    void testSumAccessibleRolls() {
        // Arrange
        final String[][] grid = new String[][]{{".", "@", "."}, {"@", "@", "@"}, {".", ".", "."}};
        final int expected = 4;

        // Act
        int result = sut.sumAccessibleRolls(grid);

        // Assert
        assertEquals(expected, result);
    }
}