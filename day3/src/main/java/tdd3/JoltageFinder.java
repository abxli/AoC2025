package tdd3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class JoltageFinder {
    public long calculateTotalJoltageForPart2(List<String> banks) {
        return banks.stream()
                .mapToLong(i -> findHighestJoltageForPart2(i, 12))
                .sum();
    }

    public long findHighestJoltageForPart2(String bank, int n) {
        // These base cases are not needed for input as they are safe
        if (n < 0 || bank.isBlank()) return Long.MIN_VALUE;
        if (bank.length() <= n) return Long.parseLong(bank);
        Deque<Integer> stack = fillStackInCorrectOrder(bank, n);

        // Build result from first n digits
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(stack.pollFirst());
        }

        return Long.parseLong(result.toString());
    }

    private static Deque<Integer> fillStackInCorrectOrder(String bank, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int skipBudget = bank.length() - n;

        for (char c : bank.toCharArray()) {
            Integer digit = Integer.parseInt(String.valueOf(c));
            // Pop smaller digits if we can still afford to remove characters
            while (!stack.isEmpty() && skipBudget > 0 && stack.peekLast() < digit) {
                // Pop from stack
                stack.removeLast();
                skipBudget--;
            }
            // Add to stack
            stack.addLast(digit);
        }
        return stack;
    }

    public int calculateTotalJoltageForPart1(List<String> banks) {
        return banks.stream()
                .mapToInt(this::findHighestJoltageForPart1)
                .sum();
    }

    public int findHighestJoltageForPart1(String bank) {
        NumberIndexPair highestPair = getHighestNumberIndexPairForPart1(bank);
        NumberIndexPair secondHighestPair = getSecondHighestNumberIndexPair(bank, highestPair);
        return Integer.parseInt(highestPair.number() + "" + secondHighestPair.number());
    }

    private NumberIndexPair getHighestNumberIndexPairForPart1(String bank) {
        int highestNumber = -1;
        int highestIndex = -1;
        for (int i = 0; i < bank.length() - 1; i++) {
            String s = String.valueOf(bank.charAt(i));
            int num = Integer.parseInt(s);
            if (num > highestNumber) {
                highestNumber = num;
                highestIndex = i;
            }
        }
        return new NumberIndexPair(highestNumber, highestIndex);
    }

    private NumberIndexPair getSecondHighestNumberIndexPair(String bank, NumberIndexPair highestPair) {
        int highestNumber = -1;
        int highestIndex = -1;
        for (int i = highestPair.index(); i < bank.length(); i++) {
            String s = String.valueOf(bank.charAt(i));
            int num = Integer.parseInt(s);
            if (num > highestNumber && i != highestPair.index()) {
                highestNumber = num;
                highestIndex = i;
            }
        }
        return new NumberIndexPair(highestNumber, highestIndex);
    }
}
