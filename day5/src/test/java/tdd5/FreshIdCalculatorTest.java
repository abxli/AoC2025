package tdd5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FreshIdCalculatorTest {
    private FreshIdCalculator sut;

    @BeforeEach
    void setup() {
        sut = new FreshIdCalculator();
    }

    @Test
    void testCalculateNumberOfFreshIds() {
        // Arrange
        final List<Range> freshIdRanges = List.of(new Range(3, 5), new Range(10, 14), new Range(16, 20), new Range(12, 18));
        final List<Long> availableIds = List.of(1L, 5L, 8L, 11L, 17L, 32L);
        final long expected = 3;

        // Act
        long result = sut.calculateNumberOfFreshIds(freshIdRanges, availableIds);

        // Assert
        assertEquals(expected, result);
    }
}