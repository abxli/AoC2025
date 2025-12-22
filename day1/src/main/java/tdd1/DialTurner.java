package tdd1;

import java.util.List;

public class DialTurner {
    private int dialValue = 50;
    private int encounteredZero = 0;

    public int turnDial(String rotation) {
        // Parsing input
        String direction = rotation.substring(0, 1);
        boolean forward = direction.equals("R");
        int totalDistance = Integer.parseInt(rotation.substring(1));

        int relativeDistance = totalDistance % 100;
        encounteredZero = (totalDistance / 100); // zeros encountered during full cycles

        if (forward) {
            turnDialToRight(relativeDistance);
        } else {
            turnDialToLeft(relativeDistance);
        }

//        System.out.println("Dial value " + dialValue + " with distance " + totalDistance);

        return dialValue;
    }

    private void turnDialToLeft(int relativeDistance) {
        int initialValue = dialValue;
        dialValue -= relativeDistance;
        if (dialValue < 0) {
            if (initialValue != 0) encounteredZero++;
            dialValue = 100 + dialValue;
        }

    }

    private void turnDialToRight(int relativeDistance) {
        dialValue += relativeDistance;
        if (dialValue > 99) {
            dialValue = dialValue - 100;
            if (dialValue != 0) encounteredZero++;
        }
    }

    public int crackPassword(List<String> instructions) {
        int count = 0;
        for (String instruction : instructions) {
            turnDial(instruction);
            if (dialPointsToZero()) count++;
        }

        return count;
    }

    public int crackPasswordUsingMethod0x434(List<String> instructions) {
        int count = 0;
        for (String instruction : instructions) {
            turnDial(instruction);
            if (dialPointsToZero()) count++;
            count += encounteredZero;
        }

        return count;
    }

    private boolean dialPointsToZero() {
        return dialValue == 0;
    }
}
