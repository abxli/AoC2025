package tdd7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day7Application {
    private static final GridParser gridParser = new GridParser();
    private static final BeamSplitter beamSplitter = new BeamSplitter();

    public static void main(String[] args) {
        final String fileName = "C:\\AoC2025\\day7\\src\\main\\resources\\input.txt";
        calculatePart1(fileName);
        calculatePart2(fileName);
    }

    public static int calculatePart1(String fileName) {
        List<String> lines = Day7Application.readLines(fileName);
        String[][] grid = gridParser.parseGrid(lines);
        int result = beamSplitter.calculateAmountOfSplitting(grid);
        System.out.println("Result for day 7 part 1: " + result);
        return result;
    }

    public static long calculatePart2(String fileName) {
        List<String> lines = Day7Application.readLines(fileName);
        String[][] grid = gridParser.parseGrid(lines);
        long result = beamSplitter.calculateAmountOfTimelines(grid);
        System.out.println("Result for day 7 part 2: " + result);
        return result;
    }

    public static List<String> readLines(String fileName) {
        List<String> lines;

        try {
            lines =  Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

}
