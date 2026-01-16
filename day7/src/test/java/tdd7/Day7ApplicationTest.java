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
}