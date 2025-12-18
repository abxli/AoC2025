package tdd11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServerNodeParserTest {
    private ServerNodeParser sut;

    @BeforeEach
    void setup() {
        sut = new ServerNodeParser();
    }

    @Test
    void testParseToGraph() {
        // Arrange
        final List<String> input = List.of("aaa: bbb ccc");
        final Graph expected = new Graph();
        expected.addEdge("aaa", "bbb");
        expected.addEdge("aaa", "ccc");

        // Act
        Graph result = sut.parseToGraph(input);

        // Assert
        assertEquals(expected, result);
    }
}
