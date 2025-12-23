package tdd1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1ApplicationTest {

    @Test
    void testReadFileToLines() {
        // Arrange
        final String testFileName = "C:\\AoC2025\\day1\\src\\test\\resources\\testInput.txt";
        final List<String> expected = List.of("R29", "L37", "L39");

        // Act
        List<String> result = Day1Application.readFileToLines(testFileName);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculatePart1() {
        // Arrange
        final int expected = 1043;

        // Act
        int result = Day1Application.calculatePart1();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculatePart2() {
        // Arrange
        final int expected = 5963;

        // Act
        int result = Day1Application.calculatePart2();

        // Assert
        assertEquals(expected, result);
    }
}
