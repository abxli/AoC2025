package tdd7;

import java.awt.*;

public class BeamSplitter {
    private long[][] memoization;

    /**
     * Calculate the number of different timelines. This is part 2 for day 7 of AoC.
     *
     * @param grid The grid to calculate the different timelines.
     *
     * @return The number of different timelines.
     */
    public long calculateAmountOfTimelines(String[][] grid) {
        Point start = getStartingPoint(grid);
        if (start == null) return 1;

        return 1 + propagateTimelines(grid, start.x + 1, start.y);
    }

    /**
     * This is a helper function to traverse the grid in a desired way to calculate the number of different timelines.
     * This is part 2 for day 7 of AoC.
     *
     * @param grid The grid to traverse.
     * @param x The 'x-coordinate' of the grid. First dimensional axis of 2d array.
     * @param y The 'y-coordinate' of the grid. Second dimensional axis of 2d array.
     *
     * @return The number of different timelines.
     */
    private long propagateTimelines(String[][] grid, int x, int y) {
        if (x >= grid.length || y < 0 || y >= grid[0].length) return 0;
        if (memoization[x][y] != 0) return memoization[x][y];

        long amountOfTimelines = 0;
        String currentCell = grid[x][y];

        if (currentCell.equals("^")) {
            amountOfTimelines = 1;
            amountOfTimelines += propagateTimelines(grid, x + 1, y - 1);
            amountOfTimelines += propagateTimelines(grid, x + 1, y + 1);
        } else if (currentCell.equals("|") || currentCell.equals(".")) {
            amountOfTimelines = propagateTimelines(grid, x + 1, y);
        }

        memoization[x][y] = amountOfTimelines;
        return amountOfTimelines;
    }

    /**
     * Calculate the amount of splitting for a given grid. This is part 1 for day 7 of AoC.
     *
     * @param grid The grid to calculate the number of splits.
     *
     * @return The number of splittings.
     */
    public int calculateAmountOfSplitting(String[][] grid) {
        Point start = getStartingPoint(grid);
        if (start == null) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return propagate(grid, start.x + 1, start.y, visited);
    }

    /**
     * Helper function to traverse the grid in a desired way to calculate the amount of splitting.
     * This is part 1 for day 7 of AoC.
     *
     * @param grid The grid to traverse and calculate the number of splittings.
     * @param x The 'x-coordinate' of the grid. First dimensional axis of 2d array.
     * @param y The 'y-coordinate' of the grid. Second dimensional axis of 2d array.
     * @param visited A 2D-array that keeps track of grid positions being visited already or not. This is to prevent counting double.
     *
     * @return The number of splittings.
     */
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
                    memoization = new long[grid.length][grid[0].length];
                    return new Point(x, y);
                }
            }
        }

        return null;
    }
}
