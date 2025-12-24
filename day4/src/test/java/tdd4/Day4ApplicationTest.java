package tdd4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day4ApplicationTest {
    @Test
    void testReadLines() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day4\\src\\test\\resources\\input.txt";
        final List<String> expected = List.of(
                "..@@.@@@@.",
                "@@@.@.@.@@",
                "@@@@@.@.@@",
                "@.@@@@..@.",
                "@@.@@@@.@@",
                ".@@@@@@@.@",
                ".@.@.@.@@@",
                "@.@@@.@@@@",
                ".@@@@@@@@.",
                "@.@.@@@.@."
        );

        // Act
        List<String> result = Day4Application.readLines(fileName);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculatePart1() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day4\\src\\test\\resources\\input.txt";
        final int expected = 13;

        // Act
        int result = Day4Application.calculatePart1(fileName);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculatePart2() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day4\\src\\test\\resources\\input.txt";
        final int expected = 43;

        // Act
        int result = Day4Application.calculatePart2(fileName);

        // Assert
        assertEquals(expected, result);
    }
}