package tdd5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day5Application {
    private static final InputTupleParser parser = new InputTupleParser();
    private static final FreshIdCalculator freshIdCalculator = new FreshIdCalculator();

    public static void main(String[] args) {
        final String fileName = "C:\\AoC2025\\day5\\src\\main\\resources\\input.txt";
        calculatePart1(fileName);
    }

    public static long calculatePart1(String fileName) {
        List<String> lines = readLines(fileName);
        InputTuple tuple = parser.parseTuples(lines);
        long result = freshIdCalculator.calculateNumberOfFreshIds(tuple.freshIdRanges(), tuple.availableIds());
        System.out.println("Number of Fresh Ingredient Ids: " + result);
        return result;
    }

    public static List<String> readLines(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
