package tdd5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day5ApplicationTest {

    @Test
    void testReadLines() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day5\\src\\test\\resources\\input.txt";
        final List<String> expected = List.of(
                "3-5",
                "10-14",
                "16-20",
                "12-18",
                "",
                "1",
                "5",
                "8",
                "11",
                "17",
                "32"
        );

        // Act
        List<String> result = Day5Application.readLines(fileName);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculatePart1() {
        // Arrange
        final String fileName = "C:\\AoC2025\\day5\\src\\test\\resources\\input.txt";
        final long expected = 3;

        // Act
        long result = Day5Application.calculatePart1(fileName);

        // Assert
        assertEquals(expected, result);
    }
}