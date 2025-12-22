package tdd11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private Graph sut;

    @BeforeEach
    void setup() {
        sut = new Graph();
    }

    @Test
    void testAddEdge() {
        // Arrange
        final String startNode = "aaa";
        final String destinationNode = "bbb";

        // Act
        sut.addEdge(startNode, destinationNode);

        // Assert
        assertTrue(sut.hasEdge(startNode, destinationNode));
    }

    @Test
    void testHasEdge() {
        // Arrange
        final String startNode = "aaa";
        final String destinationNode = "bbb";
        sut.addEdge(startNode, destinationNode);
        final String lonelyNode = "ccc";

        // Act
        boolean result = sut.hasEdge(startNode, lonelyNode);

        // Assert
        assertFalse(result);
    }

    @Test
    void testGetNumberOfUniquePaths() {
        // Arrange
        final String startNode = "aaa";
        final String destinationNode = "bbb";
        sut.addEdge(startNode, destinationNode);
        sut.addEdge(startNode, "ccc");
        sut.addEdge("ccc", destinationNode);
        final long expected = 2;

        // Act
        long result = sut.getNumberOfUniquePaths(startNode, destinationNode);

        // Assert
        assertEquals(expected, result);
    }
}