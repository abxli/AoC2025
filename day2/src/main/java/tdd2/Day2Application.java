package tdd2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Day2Application {
    private static final RangeParser rangeParser = new RangeParser();
    private static final InvalidIdCalculator invalidIdCalculator = new InvalidIdCalculator();

    public static void main(String[] args) {
        final String fileName = "C:\\AoC2025\\day2\\src\\main\\resources\\input.txt";
        calculatePart1(fileName);
        calculatePart2(fileName);
    }

    public static long calculatePart1(final String fileName) {
        List<String> stringRanges = readIdRanges(fileName);
        List<Range> ranges = rangeParser.parseRanges(stringRanges);
        long result = invalidIdCalculator.calculateTotalInvalidIdsForPart1(ranges);
        System.out.println("Result for part 1 is: " + result);
        return result;
    }

    public static long calculatePart2(String fileName) {
        List<String> stringRanges = readIdRanges(fileName);
        List<Range> ranges = rangeParser.parseRanges(stringRanges);
        long result = invalidIdCalculator.calculateTotalInvalidIdsForPart2(ranges);
        System.out.println("Result for part 2 is: " + result);
        return result;
    }

    public static List<String> readIdRanges(String fileName) {
        List<String> stringRanges;

        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            stringRanges = Arrays.stream(reader.readLine().split(",")).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringRanges;
    }
}
