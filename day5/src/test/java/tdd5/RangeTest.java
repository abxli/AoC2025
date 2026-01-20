package tdd5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void testOverlaps() {
        // Arrange
        final Range range1 = new Range(0, 5);
        final Range range2 = new Range(3, 7);

        // Act
        boolean result = range1.overlaps(range2);

        // Assert
        assertTrue(result);
    }

    @Test
    void testOverlaps_notOverLapping() {
        // Arrange
        final Range range1 = new Range(0, 5);
        final Range range2 = new Range(6, 7);

        // Act
        boolean result = range1.overlaps(range2);

        // Assert
        assertFalse(result);
    }

    @Test
    void testTakeUnionRangeWhenIntersecting() {
        // Arrange
        final Range range1 = new Range(0, 5);
        final Range range2 = new Range(3, 7);
        final Range expected = new Range(0, 7);

        // Act
        Range result = range1.takeUnionRangeWhenIntersecting(range2);

        // Assert
        assertEquals(expected, result);
    }
}