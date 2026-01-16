package tdd7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day7ApplicationTest {

    @Test
    void testReadLines() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day7\\src\\test\\resources\\input.txt";
        final List<String> expected = List.of(
                ".......S.......",
                "...............",
                ".......^.......",
                "...............",
                "......^.^......",
                "...............",
                ".....^.^.^.....",
                "...............",
                "....^.^...^....",
                "...............",
                "...^.^...^.^...",
                "...............",
                "..^...^.....^..",
                "...............",
                ".^.^.^.^.^...^.",
                "..............."
        );

        // Act
        List<String> result = Day7Application.readLines(fileName);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculatePart1() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day7\\src\\test\\resources\\result.txt";
        final int expected = 1640;

        // Act
        int result = Day7Application.calculatePart1(fileName);

        // Assert
        assertEquals(expected, result);
    }
}