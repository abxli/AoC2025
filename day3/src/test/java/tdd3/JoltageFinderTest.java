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
    @MethodSource("inputFor_testFindHighestJoltage")
    void testFindHighestJoltage(final int expected, final String bank) {
        // Act
        int result = sut.findHighestJoltage(bank);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testFindHighestJoltage() {
        // Arrange
        return Stream.of(
                Arguments.of(78, "12345678"),
                Arguments.of(98, "12945678"),
                Arguments.of(77, "17345670")
        );
    }

    @Test
    void testCalculateTotalJoltage() {
        //
        final List<String> banks = List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111");
        final int expected = 357;

        // Act
        int result = sut.calculateTotalJoltage(banks);

        // Assert
        assertEquals(expected, result);
    }
}