package tdd2;

import java.util.List;

public class InvalidIdCalculator {
    /**
     * Calculate the total sum of all invalid ids, given a list of ranges. AoC 2025 day 2 part 2.
     *
     * @param ranges The ranges to check the invalid ids for, as a list.
     *
     * @return The total sum of all invalid ids.
     */
    public long calculateTotalInvalidIdsForPart2(List<Range> ranges) {
        long totalSum = 0L;
        for (Range range : ranges) {
            totalSum += calculateSumInvalidIdsForPart2(range);
        }
        return totalSum;
    }

    /**
     * Calculate the sum of invalid ids given a range. AoC 2025 day 2 part 2.
     *
     * @param range The range to sum the invalid ids for.
     *
     * @return The sum of invalid ids.
     */
    public long calculateSumInvalidIdsForPart2(Range range) {
        long sum = 0;
        for (long i = range.firstId(); i <= range.lastId(); i++) {
            String input = Long.toString(i);
            if (idIsInvalidSinceItRepeatedAtLeastTwice(input)) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * ID is deemed invalid if id is repeated twice exactly. AoC 2025 day 2 part 2.
     *
     * @param input The string input id to check.
     *
     * @return true if it is invalid, false otherwise.
     */
    private static boolean idIsInvalidSinceItRepeatedAtLeastTwice(String input) {
        int length = input.length();
        for (int chunkSize = 1; chunkSize < length; chunkSize++) {
            if (length % chunkSize != 0) continue;
            if (isInputRepeated(input, chunkSize, length)) return true;
        }
        return false;
    }

    private static boolean isInputRepeated(String input, int chunkSize, int length) {
        boolean idIsInvalid = false;
        String firstChunk = input.substring(0, chunkSize);
        for (int i = 1; i < length / chunkSize; i++) {
            String subsequentChunk = input.substring(i * chunkSize, (i + 1) * chunkSize);
            if (!firstChunk.equals(subsequentChunk)) {
                idIsInvalid = false;
                break;
            } else {
                idIsInvalid = true;
            }
        }
        return idIsInvalid;
    }

    /**
     * Calculate the total sum of all invalid ids, given a list of ranges. AoC 2025 day 2 part 1.
     *
     * @param ranges The ranges to check the invalid ids for, as a list.
     *
     * @return The total sum of all invalid ids.
     */
    public long calculateTotalInvalidIdsForPart1(List<Range> ranges) {
        long totalSum = 0L;
        for (Range range : ranges) {
            totalSum += calculateSumInvalidIdsForPart1(range);
        }
        return totalSum;
    }

    /**
     * Calculate the sum of invalid ids given a range. AoC 2025 day 2 part 1.
     *
     * @param range The range to sum the invalid ids for.
     *
     * @return The sum of invalid ids.
     */
    public long calculateSumInvalidIdsForPart1(Range range) {
        long sum = 0;
        for (long i = range.firstId(); i <= range.lastId(); i++) {
            String input = Long.toString(i);
            if (inputIsOfEvenLength(input) && idIsInvalidSinceItRepeatedExactlyTwice(input)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean inputIsOfEvenLength(String input) {
        return (input.length() % 2) == 0;
    }

    /**
     * ID is deemed invalid if id is repeated twice exactly. AoC 2025 day 2 part 1.
     *
     * @param input The string input id to check.
     *
     * @return true if it is invalid, false otherwise.
     */
    private static boolean idIsInvalidSinceItRepeatedExactlyTwice(String input) {
        int halfLength = input.length() / 2;
        String firstPart = input.substring(0, halfLength);
        String secondPart = input.substring(halfLength);
        return firstPart.equals(secondPart);
    }
}
