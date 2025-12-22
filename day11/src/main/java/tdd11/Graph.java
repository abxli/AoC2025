package tdd11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Graph {
    private final Map<String, List<String>> neighboursMap = new HashMap<>();
    private final Map<String, Long> cache = new HashMap<>();

    // add edge
    public void addEdge(String from, String to) {
        // Init new list if not seen this before
        if (!neighboursMap.containsKey(from)) {
            neighboursMap.put(from, new ArrayList<>());
        }

        if (!neighboursMap.containsKey(to)) {
            neighboursMap.put(to, new ArrayList<>());
        }

        neighboursMap.get(from).add(to);
    }

    // has edge
    public boolean hasEdge(String start, String end) {
        List<String> nextNodes = neighboursMap.get(start);
        if (nextNodes == null || nextNodes.isEmpty()) return false;
        return nextNodes.contains(end);
    }

    // find number of different paths - BFS or DP
    public long getNumberOfUniquePaths(String start, String end) {
        String key = start + "-" + end;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // Base case
        if (start.equals(end)) {
            cache.put(key, 1L);
            return 1;
        }

        long count = 0;
        List<String> neighbours = neighboursMap.get(start);
        for (String neighbour : neighbours) {
            count += getNumberOfUniquePaths(neighbour, end);
        }

        cache.put(key, count);

        return count;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Graph graph)) return false;
        return Objects.equals(neighboursMap, graph.neighboursMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(neighboursMap);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "map=" + neighboursMap +
                '}';
    }
}
