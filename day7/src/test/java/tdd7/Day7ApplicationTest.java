package tdd7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("inputFor_testCalculatePart1")
    void testCalculatePart1(final String fileName, final int expected) {
        // Act
        int result = Day7Application.calculatePart1(fileName);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testCalculatePart1() {
        // Arrange
        return Stream.of(
                Arguments.of("C:\\AoC2025\\day7\\src\\test\\resources\\input.txt", 21),
                Arguments.of("C:\\AoC2025\\day7\\src\\test\\resources\\result.txt", 1640)
        );
    }

    @ParameterizedTest
    @MethodSource("inputFor_testCalculatePart2")
    void testCalculatePart2(final String fileName, final long expected) {
        // Act
        long result = Day7Application.calculatePart2(fileName);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testCalculatePart2() {
        // Arrange
        return Stream.of(
                Arguments.of("C:\\AoC2025\\day7\\src\\test\\resources\\input.txt", 40),
                Arguments.of("C:\\AoC2025\\day7\\src\\test\\resources\\result.txt", 40999072541589L)
        );
    }
}