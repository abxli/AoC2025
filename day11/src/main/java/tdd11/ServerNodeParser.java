package tdd11;

import java.util.List;

public class ServerNodeParser {
    public Graph parseToGraph(List<String> lines) {
        Graph result = new Graph();
        for (String line : lines) {
            String[] content = line.replace(":", "").split("\\s");
            String startNode = "Invalid";

            for (int i = 0; i < content.length; i++) {
                if (i == 0) {
                    // First element: indicates from
                    startNode = content[i];
                    continue;
                }
                result.addEdge(startNode, content[i]);
            }
        }
        return result;
    }
}
