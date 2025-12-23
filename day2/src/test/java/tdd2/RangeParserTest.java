package tdd2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeParserTest {
    private RangeParser sut;

    @BeforeEach
    void setUp() {
        sut = new RangeParser();
    }

    @Test
    void testParseRange() {
        // Arrange
        final String rangeInput = "11-22";
        final Range expected = new Range(11L, 22L);

        // Act
        Range result = sut.parseRange(rangeInput);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testParseRanges() {
        // Arrange
        final List<String> rangesInput = List.of("11-22");
        final List<Range> expected = List.of(new Range(11L, 22L));

        // Act
        List<Range> result = sut.parseRanges(rangesInput);

        // Assert
        assertEquals(expected, result);
    }
}
