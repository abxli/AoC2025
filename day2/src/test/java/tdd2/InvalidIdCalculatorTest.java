package tdd2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InvalidIdCalculatorTest {
    private InvalidIdCalculator sut;

    @BeforeEach
    void setUp() {
        sut = new InvalidIdCalculator();
    }

    @ParameterizedTest
    @MethodSource("inputFor_testCalculateSumInvalidIdsForPart1")
    void testCalculateSumInvalidIdsForPart1(final Range range, final long expected) {
        // Act
        long result = sut.calculateSumInvalidIdsForPart1(range);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testCalculateSumInvalidIdsForPart1() {
        // Arrange
        return Stream.of(
                Arguments.of(new Range(11L, 22L), 33L),
                Arguments.of(new Range(95L, 115L), 99L),
                Arguments.of(new Range(998L, 1012L), 1010L),
                Arguments.of(new Range(1188511880L, 1188511890L), 1188511885L),
                Arguments.of(new Range(222220L, 222224L), 222222L),
                Arguments.of(new Range(1698522L, 1698528L), 0L),
                Arguments.of(new Range(446443L, 446449L), 446446L),
                Arguments.of(new Range(38593856L, 38593862L), 38593859L)
        );
    }

    @Test
    void testCalculateTotalInvalidIdsForPart1() {
        // Arrange
        final List<Range> ranges = List.of(new Range(11L, 22L),
                new Range(95L, 115L),
                new Range(998L, 1012L),
                new Range(1188511880L, 1188511890L),
                new Range(222220L, 222224L),
                new Range(1698522L, 1698528L),
                new Range(446443L, 446449L),
                new Range(38593856L, 38593862L));
        final long expected = 1227775554L;

        // Act
        long result = sut.calculateTotalInvalidIdsForPart1(ranges);

        // Assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("inputFor_testCalculateSumInvalidIdsForPart2")
    void testCalculateSumInvalidIdsForPart2(final Range range, final long expected) {
        // Act
        long result = sut.calculateSumInvalidIdsForPart2(range);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testCalculateSumInvalidIdsForPart2() {
        // Arrange
        return Stream.of(
                Arguments.of(new Range(11L, 22L), 33L),
                Arguments.of(new Range(95L, 115L), 210L),
                Arguments.of(new Range(998L, 1012L), 999L + 1010L),
                Arguments.of(new Range(1188511880L, 1188511890L), 1188511885L),
                Arguments.of(new Range(222220L, 222224L), 222222L),
                Arguments.of(new Range(1698522L, 1698528L), 0L),
                Arguments.of(new Range(446443L, 446449L), 446446L),
                Arguments.of(new Range(38593856L, 38593862L), 38593859L),
                Arguments.of(new Range(565653L, 565659L), 565656L),
                Arguments.of(new Range(824824821L, 824824827L), 824824824L),
                Arguments.of(new Range(2121212118L, 2121212124L), 2121212121)
        );
    }

    @Test
    void testCalculateTotalInvalidIdsForPart2() {
        // Arrange
        final List<Range> ranges = List.of(new Range(11L, 22L),
                new Range(95L, 115L),
                new Range(998L, 1012L),
                new Range(1188511880L, 1188511890L),
                new Range(222220L, 222224L),
                new Range(1698522L, 1698528L),
                new Range(446443L, 446449L),
                new Range(38593856L, 38593862L),
                new Range(565653L, 565659L),
                new Range(824824821L, 824824827L),
                new Range(2121212118L, 2121212124L));
        final long expected = 4174379265L;

        // Act
        long result = sut.calculateTotalInvalidIdsForPart2(ranges);

        // Assert
        assertEquals(expected, result);
    }
}