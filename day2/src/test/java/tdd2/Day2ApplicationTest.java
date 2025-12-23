package tdd2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2ApplicationTest {
    @Test
    void testReadIdRanges() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day2\\src\\test\\resources\\input.txt";
        final List<String> expected = List.of("1-10", "2-20");

        // Act
        List<String> ranges = Day2Application.readIdRanges(fileName);

        // Assert
        assertEquals(expected, ranges);
    }

    @Test
    void testCalculatePart1() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day2\\src\\test\\resources\\input.txt";
        final int expected = 11;

        // Act
        long result = Day2Application.calculatePart1(fileName);

        // Assert
        assertEquals(expected, result);
    }
}
