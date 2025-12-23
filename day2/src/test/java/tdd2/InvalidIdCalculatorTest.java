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
    @MethodSource("inputFor_testCalculateSumInvalidIds")
    void testCalculateSumInvalidIds(final Range range, final long expected) {
        // Act
        long result = sut.calculateSumInvalidIds(range);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testCalculateSumInvalidIds() {
        // Arrange
        return Stream.of(
                Arguments.of(new Range(11L, 22L), 33L),
                Arguments.of(new Range(95L, 115L), 99L),
                Arguments.of(new Range(1188511880L, 1188511890L), 1188511885L),
                Arguments.of(new Range(222220L, 222224L), 222222L),
                Arguments.of(new Range(1698522L, 1698528L), 0L),
                Arguments.of(new Range(446443L, 446449L), 446446L),
                Arguments.of(new Range(38593856L, 38593862L), 38593859L)
        );
    }

    @Test
    void testCalulcateTotalInvalidIds() {
        // Arrange
        final List<Range> ranges = List.of(new Range(11L, 22L),
                new Range(95L, 115L),
                new Range(1188511880L, 1188511890L),
                new Range(222220L, 222224L),
                new Range(1698522L, 1698528L),
                new Range(446443L, 446449L),
                new Range(38593856L, 38593862L));
        final long expected = 1227774544L;

        // Act
        long result = sut.calculateTotalInvalidIds(ranges);

        // Assert
        assertEquals(expected, result);
    }

}