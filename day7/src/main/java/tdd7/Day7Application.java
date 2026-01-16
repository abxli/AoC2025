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
    }

    public static int calculatePart1(String fileName) {
        List<String> lines = Day7Application.readLines(fileName);
        String[][] grid = gridParser.parseGrid(lines);
        int result = beamSplitter.calculateAmountOfSplitting(grid);
        System.out.println(result);
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
