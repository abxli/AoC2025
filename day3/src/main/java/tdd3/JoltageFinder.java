package tdd3;

import java.util.List;

public class JoltageFinder {
    public int calculateTotalJoltage(List<String> banks) {
        return banks.stream()
                .mapToInt(this::findHighestJoltage)
                .sum();
    }

    public int findHighestJoltage(String bank) {
        NumberIndexPair highestPair = getHighestNumberIndexPair(bank);
        NumberIndexPair secondHighestPair = getSecondHighestNumberIndexPair(bank, highestPair);
        return Integer.parseInt(highestPair.number() + "" + secondHighestPair.number());
    }

    private NumberIndexPair getHighestNumberIndexPair(String bank) {
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
