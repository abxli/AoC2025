package tdd4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GridParserTest {
    private GridParser sut;

    @BeforeEach
    void setUp() {
        sut = new GridParser();
    }

    @Test
    void testParseGrid() {
        // Arrange
        final List<String> lines = List.of("@@@", "...", ".@.");
        final String[][] expected = new String[][]{{"@","@","@"}, {".",".","."}, {".","@","."}};

        // Act
        String[][] result = sut.parseGrid(lines);

        // Assert
        assertArrayEquals(expected, result);
    }
}