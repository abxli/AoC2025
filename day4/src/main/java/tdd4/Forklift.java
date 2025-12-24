package tdd4;


import java.awt.*;
import java.util.Set;

public class Forklift {
    private int removableScrolls = 0;

    public int getRemovableScrolls() {
        return removableScrolls;
    }

    public int sumRemovableRolls(String[][] grid) {
        String[][] newGrid = removeRollsFromGrid(grid);
        if (areGridsTheSame(grid, newGrid)) return removableScrolls;
        else return sumRemovableRolls(newGrid);
    }

    public String[][] removeRollsFromGrid(String[][] grid) {
        String[][] result = new String[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                Point point = new Point(x, y);
                if (isPointAScroll(point, grid) && isAccessibleRoll(point, grid)) {
                    result[x][y] = "x";
                    removableScrolls++;
                } else {
                    result[x][y] = grid[x][y];
                }
            }
        }
        return result;
    }

    private boolean areGridsTheSame(String[][] grid, String[][] newGrid) {
        if (grid.length != newGrid.length) return false;
        for (int x = 0; x < grid.length; x++) {
            if (grid[x].length != newGrid[x].length) return false;
            for (int y = 0; y < grid[0].length; y++) {
                if (!grid[x][y].equals(newGrid[x][y])) return false;
            }
        }
        return true;
    }
    public int sumAccessibleRolls(String[][] grid) {
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                Point point = new Point(x, y);
                if (isPointAScroll(point, grid) && isAccessibleRoll(point, grid)) count++;
            }
        }
        return count;
    }

    private boolean isPointAScroll(Point point, String[][] grid) {
        return grid[point.x][point.y].equals("@");
    }

    public boolean isAccessibleRoll(Point point, String[][] grid) {
        int countAdjacentScrolls = 0;
        Set<Point> coordinates = Set.of(
                new Point(point.x - 1, point.y), // left
                new Point(point.x - 1, point.y - 1), // left-up
                new Point(point.x, point.y - 1), // up
                new Point(point.x + 1, point.y - 1), // right-up
                new Point(point.x + 1, point.y), // right
                new Point(point.x + 1, point.y + 1), // right-down
                new Point(point.x, point.y + 1), // down
                new Point(point.x - 1, point.y + 1) // left-down
        );
        for (Point coordinate : coordinates) {
            if (!isPointWithinGrid(coordinate, grid)) continue;
            if (grid[coordinate.x][coordinate.y].equals("@")) countAdjacentScrolls++;
            if (countAdjacentScrolls >= 4) return false;
        }

        return true;
    }

    private static boolean isPointWithinGrid(Point point, String[][] grid) {
        return point.x >= 0 && point.x < grid.length
                && point.y >= 0 && point.y < grid[point.x].length;
    }
}
