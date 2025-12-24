package tdd4;

import java.util.List;

public class GridParser {
    public String[][] parseGrid(List<String> lines) {
        /* Here is the for loop version I started out with
        String[][] result = new String[lines.size()][];
        for (int x = 0; x < lines.size(); x++) {
            String s = lines.get(x);
            result[x] = new String[s.length()];
            for (int y = 0; y < s.length(); y++) {
                result[x][y] = String.valueOf(s.charAt(y));
            }
        }*/

        return lines.stream()
                .map(s -> s.chars()
                        .mapToObj(c -> String.valueOf((char) c))
                        .toArray(String[]::new))
                .toArray(String[][]::new);
    }
}
