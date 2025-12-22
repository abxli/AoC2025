package tdd1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DialTurnerTest {
    private DialTurner sut;

    @BeforeEach
    void setup() {
        sut = new DialTurner();
    }

    @ParameterizedTest
    @MethodSource("inputFor_testTurnDial")
    void testTurnDial(final int expected, final String rotation) {
        // Act
        int result = sut.turnDial(rotation);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testTurnDial() {
        // Arrange
        return Stream.of(
                // Left
                Arguments.of(49, "L1"),
                Arguments.of(39, "L11"),
                Arguments.of(0, "L50"),

                // Wrapped around - once
                Arguments.of(99, "L51"),
                Arguments.of(97, "L53"),
                Arguments.of(82, "L68"),

                // Right
                Arguments.of(0, "R50"),
                Arguments.of(18, "R68"),

                // Wrapped around - multiple times
                Arguments.of(50, "R100")
        );
    }

    @Test
    void testCrackPassword() {
        // Arrange
        final int expected = 3;
        final List<String> instructions = List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82");

        // Act
        int result = sut.crackPassword(instructions);

        // Assert
        assertEquals(expected, result);
    }
}
