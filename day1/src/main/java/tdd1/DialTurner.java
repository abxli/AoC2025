package tdd1;

import java.util.List;

public class DialTurner {
    private int dialValue = 50;

    public int turnDial(String rotation) {
        // Parsing input
        String direction = rotation.substring(0, 1);
        boolean forward = direction.equals("R");
        int totalDistance = Integer.parseInt(rotation.substring(1));

        int relativeDistance = totalDistance % 100;
        if (forward) {
            dialValue += relativeDistance;
            if (dialValue > 99) {
                dialValue = dialValue - 100;
            }
        } else {
            dialValue -= relativeDistance;
            if (dialValue < 0) {
                dialValue = 100 + dialValue;
            }
        }

        System.out.println("Dial value " + dialValue + " with distance " + totalDistance);

        return dialValue;
    }

    public int crackPassword(List<String> instructions) {
        int count = 0;
        for (String instruction : instructions) {
            turnDial(instruction);
            if (dialPointsToZero()) count++;
        }

        return count;
    }

    private boolean dialPointsToZero() {
        return dialValue == 0;
    }
}
