package tdd3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3ApplicationTest {
    @Test
    void testReadLines() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day3\\src\\test\\resources\\input.txt";
        final List<String> expected = List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111");

        // Act
        List<String> result = Day3Application.readLines(fileName);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculatePart1() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day3\\src\\test\\resources\\input.txt";
        final int expected = 357;

        // Act
        int result = Day3Application.calculatePart1(fileName);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculatePart2() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day3\\src\\test\\resources\\input.txt";
        final long expected = 3121910778619L;

        // Act
        long result = Day3Application.calculatePart2(fileName);

        // Assert
        assertEquals(expected, result);
    }
}
