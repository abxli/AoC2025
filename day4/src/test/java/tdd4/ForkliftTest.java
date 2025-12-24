package tdd4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForkliftTest {
    private Forklift sut;

    @BeforeEach
    void setUp() {
        sut = new Forklift();
    }

    @Test
    void testIsAccessibleRoll() {
        // Arrange
        final String[][] grid = new String[][]{{".", "@", "."}, {"@", "@", "@"}, {".", ".", "."}};
        final Point point = new Point(1, 1);

        // Act
        boolean result = sut.isAccessibleRoll(point, grid);

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

    @Test
    void testRemoveRollsFromGrid() {
        // Arrange
        final String[][] grid = new String[][]{{".", "@", "."}, {"@", "@", "@"}, {".", ".", "."}};
        final String[][] expected = new String[][]{{".", "x", "."}, {"x", "x", "x"}, {".", ".", "."}};
        final int expectedRemovedScrolls = 4;

        // Act
        String[][] result = sut.removeRollsFromGrid(grid);

        // Assert
        assertArrayEquals(expected, result);
        assertEquals(expectedRemovedScrolls, sut.getRemovableScrolls());
    }

    @Test
    void testSumRemovableRolls() {
        // Arrange
        final int expected = 43;
        final String[][] grid = new String[][]{
                {".", ".", "@", "@", ".", "@", "@", "@", "@", "."},
                {"@", "@", "@", ".", "@", ".", "@", ".", "@", "@"},
                {"@", "@", "@", "@", "@", ".", "@", ".", "@", "@"},
                {"@", ".", "@", "@", "@", "@", ".", ".", "@", "."},
                {"@", "@", ".", "@", "@", "@", "@", ".", "@", "@"},
                {".", "@", "@", "@", "@", "@", "@", "@", ".", "@"},
                {".", "@", ".", "@", ".", "@", ".", "@", "@", "@"},
                {"@", ".", "@", "@", "@", ".", "@", "@", "@", "@"},
                {".", "@", "@", "@", "@", "@", "@", "@", "@", "."},
                {"@", ".", "@", ".", "@", "@", "@", ".", "@", "."},
        };

        // Act
        int result = sut.sumRemovableRolls(grid);

        // Assert
        assertEquals(expected, result);
    }
}