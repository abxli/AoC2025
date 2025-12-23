package tdd2;

import java.util.List;

public class InvalidIdCalculator {
    public long calculateTotalInvalidIds(List<Range> ranges) {
        long totalSum = 0L;
        for (Range range : ranges) {
            totalSum += calculateSumInvalidIds(range);
        }
        return totalSum;
    }

    public long calculateSumInvalidIds(Range range) {
        long sum = 0;
        for (long i = range.firstId(); i <= range.lastId(); i++) {
            String input = Long.toString(i);
            int halfLength = input.length() / 2;
            if (inputIsOfEvenLength(input) && idIsInvalid(input, halfLength)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean inputIsOfEvenLength(String input) {
        return (input.length() % 2) == 0;
    }

    private static boolean idIsInvalid(String input, int halfLength) {
        String firstPart = input.substring(0, halfLength);
        String secondPart = input.substring(halfLength);
        return firstPart.equals(secondPart);
    }
}
