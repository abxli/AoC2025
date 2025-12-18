package tdd11;

import java.util.Set;

// Each state stores: current node, visited set, and whether required stop visited
class State {
    String node;
    Set<String> visited;
    boolean hasVisitedIntermediateStops;

    State(String node, Set<String> visited, boolean hasVisitedIntermediateStops) {
        this.node = node;
        this.visited = visited;
        this.hasVisitedIntermediateStops = hasVisitedIntermediateStops;
    }
}