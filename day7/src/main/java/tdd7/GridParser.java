package tdd7;

import java.util.List;

public class GridParser {
    public String[][] parseGrid(List<String> lines) {
        String[][] grid = new String[lines.size()][];

        for (int x = 0; x < lines.size(); x++) {
            String line = lines.get(x);
            grid[x] = new String[line.length()];
            for (int y = 0; y < line.length(); y++) {
                grid[x][y] = String.valueOf(line.charAt(y));
            }
        }

        return grid;
    }
}
