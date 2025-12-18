package tdd11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day11Application {
    private static final ServerNodeParser serverNodeParser = new ServerNodeParser();
    public static void main(String[] args) {
        printResultForPart1();
        printResultForPart2();
    }

    private static void printResultForPart1() {
        String fileName = "day11\\src\\main\\resources\\input.txt";
        List<String> lines = readFileToLines(fileName);
        Graph g = serverNodeParser.parseToGraph(lines);
        System.out.println(g);
        int uniquePaths = g.getNumberOfUniquePaths("you", "out");
        System.out.println("Result for day 11 part 1 = " + uniquePaths);
    }

    private static void printResultForPart2() {
        String fileName = "day11\\src\\main\\resources\\input.txt";
        List<String> lines = readFileToLines(fileName);
        Graph g = serverNodeParser.parseToGraph(lines);
//        System.out.println(g);
        int uniquePaths =
                (g.getNumberOfUniquePaths("svr", "dac") * g.getNumberOfUniquePaths("dac", "fft") * g.getNumberOfUniquePaths("fft", "out"))
                + (g.getNumberOfUniquePaths("svr", "fft") * g.getNumberOfUniquePaths("fft", "dac") * g.getNumberOfUniquePaths("dac", "out"));
        System.out.println("Result for day 11 part 2 = " + uniquePaths);
        System.out.println("Result for day 11 part 2 = " + g.getNumberOfUniquePaths("svr", "out"));
    }

    public static List<String> readFileToLines(String fileName) {
        List<String> result;

        try {
            result = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with reading the file: " + e);
        }

        return result;
    }
}
