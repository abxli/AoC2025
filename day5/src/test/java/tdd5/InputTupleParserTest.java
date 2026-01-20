package tdd5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputTupleParserTest {
    private InputTupleParser sut;

    @BeforeEach
    void setUp() {
        sut = new InputTupleParser();
    }

    @Test
    void testParseTuples() {
        // Arrange
        final List<Range> freshIdRanges = List.of(new Range(3, 5), new Range(10, 14), new Range(16, 20), new Range(12, 18));
        final List<Long> availableIds = List.of(1L, 5L, 8L, 11L, 17L, 32L);
        final InputTuple expected = new InputTuple(freshIdRanges, availableIds);
        final List<String> lines = List.of(
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
        InputTuple result = sut.parseTuples(lines);

        // Assert
        assertEquals(expected, result);
    }
}