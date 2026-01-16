package tdd7;

import java.awt.*;

public class BeamSplitter {
    public int calculateAmountOfSplitting(String[][] grid) {
        Point start = getStartingPoint(grid);
        if (start == null) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return propagate(grid, start.x + 1, start.y, visited);
    }

    private int propagate(String[][] grid, int x, int y, boolean[][] visited) {
        if (x >= grid.length || y < 0 || y >= grid[0].length) return 0;
        if (visited[x][y]) return 0;

        visited[x][y] = true;
        String currentCell = grid[x][y];

        if (currentCell.equals("^")) {
            int amountOfSplits = 1;
            amountOfSplits += propagate(grid, x + 1, y - 1, visited);
            amountOfSplits += propagate(grid, x + 1, y + 1, visited);

            return amountOfSplits;
        } else if (currentCell.equals("|") || currentCell.equals(".")) {
            return propagate(grid, x + 1, y, visited);
        }

        return 0;
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
