package tdd1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day1Application {
    private static final DialTurner dialTurner = new DialTurner();
    public static void main(String[] args) {
        int password = calculatePart1();
        System.out.println(password);

        int correctPassword = calculatePart2();
        System.out.println(correctPassword);
    }

    public static int calculatePart1() {
        String inputFile = "C:\\AoC2025\\day1\\src\\main\\resources\\input.txt";
        List<String> lines = readFileToLines(inputFile);
        return dialTurner.crackPassword(lines);
    }

    public static int calculatePart2() {
        String inputFile = "C:\\AoC2025\\day1\\src\\main\\resources\\input.txt";
        List<String> lines = readFileToLines(inputFile);
        return dialTurner.crackPasswordUsingMethod0x434(lines);
    }

    public static List<String> readFileToLines(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
