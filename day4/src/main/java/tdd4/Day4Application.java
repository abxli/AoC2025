package tdd4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day4Application {
    private static final GridParser gridParser = new GridParser();
    private static final Forklift forklift = new Forklift();

    public static void main(String[] args) {
        final String fileName = "C:\\AoC2025\\day4\\src\\main\\resources\\input.txt";
        calculatePart1(fileName);
        calculatePart2(fileName);
    }

    public static int calculatePart1(String fileName) {
        List<String> lines = readLines(fileName);
        String[][] grid = gridParser.parseGrid(lines);
        int count = forklift.sumAccessibleRolls(grid);
        System.out.println("Result for part 1 is: " + count);
        return count;
    }

    public static int calculatePart2(String fileName) {
        List<String> lines = readLines(fileName);
        String[][] grid = gridParser.parseGrid(lines);
        int count = forklift.sumRemovableRolls(grid);
        System.out.println("Result for part 2 is: " + count);
        return count;
    }

    public static List<String> readLines(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
