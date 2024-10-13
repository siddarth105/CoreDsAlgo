package DS.Graph;

import java.util.*;

// https://www.youtube.com/watch?v=BuvKtCh0SKk&ab_channel=Geekific
public class Dijkstra {

    static Map<String, Map<String, Integer>> adjList = new HashMap<>();
    static Set<Node> visited;
    public static class Node {
        String value;
        Integer shortDistance;
        List<Node> path = new LinkedList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value);
        }
        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
        public Node(String value, Integer shortDistance) {
            this.value = value;
            this.shortDistance = shortDistance;
        }

        public Node(String value) {
            this.value = value;
        }
    }

    // TimeComplexity :: E <= N^2 :: N^2(log N)
    public static void dijShortPath(String src) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.shortDistance-n2.shortDistance;
            }
        });
        visited = new HashSet<>();
        Map<String, Integer> distances = new HashMap<>();
        for (String vertex : adjList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        Node srcNode = new Node(src, 0);
        pq.add(srcNode);

        while(!pq.isEmpty()) {
            Node nd = pq.poll();    // O (log N)
            visited.add(nd);
            int dist = nd.shortDistance;

            Map<String, Integer> neighbours = adjList.get(nd.value);
            for (Map.Entry<String, Integer> entry : neighbours.entrySet()) {
                Node neighbourNode = new Node(entry.getKey());
                if (!visited.contains(neighbourNode)) {
                    int curDist = entry.getValue()+dist;
                    if (curDist < distances.get(entry.getKey())) {
                        neighbourNode.shortDistance = curDist;
                        neighbourNode.path.add(nd);
                        neighbourNode.path.addAll(nd.path);
                        distances.put(entry.getKey(), curDist);
                        if (pq.contains(neighbourNode)) {
                            pq.remove(neighbourNode);           // O(N)
                        }
                        pq.add(neighbourNode);                  // O (log N)
                    }
                }
            }
        }
    }

    public static void main (String[] args) {

        String[] vertices = {"A", "B", "C", "D", "E", "F"};
        addVertex(vertices);
        addEdge("A", "B", 4);
        addEdge("B", "D", 3);
        addEdge("A", "C", 1);
        addEdge("B", "C", 1);
        addEdge("C", "D", 2);
        addEdge("C", "E", 2);
        addEdge("E", "F", 1);
        addEdge("D", "F", 3);
        dijShortPath("A");
        printShortestPath("A");

    }

    private static void printShortestPath(String source) {
        System.out.println("Source :: " +source);
        for (Node nd : visited) {
            System.out.print("Node :: " + nd.value + ", Path :: ");
            for (Node pathNode : nd.path) {
                System.out.print(pathNode.value + " -> ");
            }
            System.out.println(", Dist :: " + nd.shortDistance);
        }
    }

    private static void addVertex(String[] vertices) {
        for (String vertex : vertices) {
            adjList.put(vertex, new HashMap<>());
        }
    }

    private static void addEdge(String from, String to, Integer weight) {
        adjList.get(from).put(to, weight);
        adjList.get(to).put(from, weight);
    }
}