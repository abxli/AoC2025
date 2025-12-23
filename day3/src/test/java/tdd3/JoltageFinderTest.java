package tdd3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JoltageFinderTest {
    private JoltageFinder sut;

    @BeforeEach
    void setup() {
        sut = new JoltageFinder();
    }

    @ParameterizedTest
    @MethodSource("inputFor_testFindHighestJoltageForPart2")
    void testFindHighestJoltageForPart2(final String bank, final long expected) {
        // Act
        long result = sut.findHighestJoltageForPart2(bank, 12);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testFindHighestJoltageForPart2() {
        // Arrange
        return Stream.of(
                Arguments.of("123456789012", 123456789012L),
                Arguments.of("923456789012", 923456789012L),
                Arguments.of("987654321111111", 987654321111L),
                Arguments.of("811111111111119", 811111111119L),
                Arguments.of("234234234234278", 434234234278L),
                Arguments.of("818181911112111", 888911112111L),
                Arguments.of("919191919191919191919191", 999999999999L)
        );
    }

    @Test
    void testCalculateTotalJoltageForPart2() {
        //
        final List<String> banks = List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111");
        final long expected = 3121910778619L;

        // Act
        long result = sut.calculateTotalJoltageForPart2(banks);

        // Assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("inputFor_testFindHighestJoltageForPart1")
    void testFindHighestJoltageForPart1(final int expected, final String bank) {
        // Act
        int result = sut.findHighestJoltageForPart1(bank);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testFindHighestJoltageForPart1() {
        // Arrange
        return Stream.of(
                Arguments.of(78, "12345678"),
                Arguments.of(98, "12945678"),
                Arguments.of(77, "17345670")
        );
    }

    @Test
    void testCalculateTotalJoltageForPart1() {
        //
        final List<String> banks = List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111");
        final int expected = 357;

        // Act
        int result = sut.calculateTotalJoltageForPart1(banks);

        // Assert
        assertEquals(expected, result);
    }
}