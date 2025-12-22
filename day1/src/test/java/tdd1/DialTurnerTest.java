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

    @ParameterizedTest
    @MethodSource("inputFor_testCrackPasswordUsingMethod0x434")
    void testCrackPasswordUsingMethod0x434(final int expected, final List<String> instructions) {
        // Act
        int result = sut.crackPasswordUsingMethod0x434(instructions);

        // Assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputFor_testCrackPasswordUsingMethod0x434() {
        // Arrange
        return Stream.of(
                Arguments.of(1, List.of("L68")),
                Arguments.of(1, List.of("L68", "L30")),
                Arguments.of(2, List.of("L68", "L30", "R48")),
                Arguments.of(2, List.of("L68", "L30", "R48", "L5")),
                Arguments.of(3, List.of("L68", "L30", "R48", "L5", "R60")),
                Arguments.of(4, List.of("L68", "L30", "R48", "L5", "R60", "L55")),
                Arguments.of(4, List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1")),
                Arguments.of(5, List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99")),
                Arguments.of(5, List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14")),
                Arguments.of(6, List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82")),

                Arguments.of(4, List.of("L102", "L200", "L48")),
                Arguments.of(1, List.of("L100")),
                Arguments.of(2, List.of("L100", "L50")),
                Arguments.of(4, List.of("L100", "L50", "L100")), // I thought it should be 3 before
                Arguments.of(10, List.of("L1000")),
                Arguments.of(4, List.of("L100", "L50", "R100")), // I thought it should be 3 before
                Arguments.of(5, List.of("R100", "R50", "R200")), // I thought it should be 4 before
                Arguments.of(4, List.of("L51", "R2", "L2", "R2"))
        );
    }
}
