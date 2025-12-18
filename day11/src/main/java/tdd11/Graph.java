package tdd11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Graph {
    private final Map<String, List<String>> map = new HashMap<>();
    private final Map<String, Integer> cache = new HashMap<>();

    // add edge
    public void addEdge(String from, String to) {
        // Init new list if not seen this before
        if (!map.containsKey(from)) {
            map.put(from, new ArrayList<>());
        }

        if (!map.containsKey(to)) {
            map.put(to, new ArrayList<>());
        }

        map.get(from).add(to);
    }

    // has edge
    public boolean hasEdge(String start, String end) {
        List<String> nextNodes = map.get(start);
        if (nextNodes == null || nextNodes.isEmpty()) return false;
        return nextNodes.contains(end);
    }

    // find number of different paths - BFS or DP
    public int getNumberOfUniquePaths(String start, String end) {
        String key = start + "-" + end;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // Base case
        if (start.equals(end)) {
            cache.put(key, 1);
            return 1;
        }

        int count = 0;
        List<String> neighbours = map.get(start);
        for (String neighbour : neighbours) {
            count += getNumberOfUniquePaths(neighbour, end);
        }

        cache.put(key, count);

        return count;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Graph graph)) return false;
        return Objects.equals(map, graph.map);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(map);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "map=" + map +
                '}';
    }
}
