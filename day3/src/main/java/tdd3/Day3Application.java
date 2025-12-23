package tdd3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day3Application {
    private static final JoltageFinder joltageFinder = new JoltageFinder();

    public static void main(String[] args) {
        final String fileName = "C:\\AoC2025\\day3\\src\\main\\resources\\input.txt";
        calculatePart1(fileName);
        calculatePart2(fileName);
    }

    public static int calculatePart1(String fileName) {
        List<String> lines = readLines(fileName);
        int result = joltageFinder.calculateTotalJoltageForPart1(lines);
        System.out.println("Result for part 1 is: " + result);
        return result;
    }

    public static long calculatePart2(String fileName) {
        List<String> lines = readLines(fileName);
        long result = joltageFinder.calculateTotalJoltageForPart2(lines);
        System.out.println("Result for part 2 is: " + result);
        return result;
    }

    public static List<String> readLines(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
