package tdd7;

import java.awt.*;
import java.util.LinkedList;

public class BeamSplitter {
    public int calculateAmountOfSplitting(String[][] grid) {
        Point start = getStartingPoint(grid);
        if (start == null) return 0;
        int amountOfSplitting = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        java.util.Queue<Point> q = new LinkedList<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            Point currentPoint = q.poll();
            int currentXPos = currentPoint.x + 1;
            if (currentXPos >= grid.length) break;

            if (grid[currentXPos][currentPoint.y].equals("^")) {
                if (!visited[currentXPos][currentPoint.y]) {
                    visited[currentXPos][currentPoint.y] = true;
                    amountOfSplitting++;
                    Point leftBeam = new Point(currentXPos + 1, currentPoint.y - 1);
                    Point rightBeam = new Point(currentXPos + 1, currentPoint.y + 1);
                    q.add(leftBeam);
                    q.add(rightBeam);
                }

            } else {
                q.add(new Point(currentXPos, currentPoint.y));
            }
        }
        
        return amountOfSplitting;
    }

    public Point getStartingPoint(String[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y].equals("S")) {
                    return new Point(x, y);
                }
            }
        }

        return null;
    }
}
