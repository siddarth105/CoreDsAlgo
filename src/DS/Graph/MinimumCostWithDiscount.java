package DS.Graph;

import java.util.*;

// QN :: https://leetcode.ca/2021-12-16-2093-Minimum-Cost-to-Reach-City-With-Discounts/
public class MinimumCostWithDiscount {

    public static class Node {
        int cost, city, discounts;

        public Node(int cost, int city, int discounts) {
            this.cost = cost;
            this.city = city;
            this.discounts = discounts;
        }

        public Node(int cost, int city) {
            this.cost = cost;
            this.city = city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node node)) return false;
            return city == node.city;
        }

        @Override
        public int hashCode() {
            return Objects.hash(city);
        }
    }


    public static int minimumCost(int n, int[][] highways, int discounts) {
        Map<Node, List<Node>> graph = new HashMap<>();

        buildAdjacencyList(highways, graph);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(0, 0, 0));

        boolean[] visited = new boolean[n];

        // keep track of the minimum cost with discounts used at each node
        int[][] dist = new int[n][discounts + 1];
        for (int[] distances : dist) {
            Arrays.fill(distances, Integer.MAX_VALUE);
        }

        while (!pq.isEmpty()) {
            Node nd = pq.poll();
            visited[nd.city] = true;

            // Skip if we've found a better way already or exceeded discount limits
            if (nd.discounts > discounts || dist[nd.city][nd.discounts] <= nd.cost) {
                continue;
            }

            // BASE :: Reached the destination
            if (nd.city == n - 1) {
                return nd.cost;
            }

            // Update the distance array
            dist[nd.city][nd.discounts] = nd.cost;

            // Explore all adjacent nodes
            for (Node neighbour : graph.get(nd)) {
                int neighbor = neighbour.city, neighborCost = neighbour.cost;

                if (!visited[neighbor]) {
                    // Offer the regular cost to visit the neighbor
                    pq.offer(new Node(nd.cost + neighborCost, neighbor, nd.discounts));
                    // If applicable, offer the discounted cost to visit the neighbor
                    if (nd.discounts < discounts) {
                        pq.offer(new Node(nd.cost + neighborCost / 2, neighbor, nd.discounts + 1));
                    }
                }
            }
        }

        // Return -1 if there is no path from node 0 to node n-1
        return -1;
    }

    private static void buildAdjacencyList(int[][] highways, Map<Node, List<Node>> graph) {
        for (int[] highway : highways) {
            int from = highway[0], to = highway[1], cost = highway[2];
            Node fromNode = new Node(cost, from);
            Node toNode = new Node(cost, to);

            List<Node> edgesOfFrom = graph.get(fromNode);
            if(null == edgesOfFrom || edgesOfFrom.isEmpty()) {
                edgesOfFrom = new ArrayList<>();
            }
            edgesOfFrom.add(toNode);
            graph.put(fromNode, edgesOfFrom);

            List<Node> edgesOfTo = graph.get(toNode);
            if(null == edgesOfTo || edgesOfTo.isEmpty()) {
                edgesOfTo = new ArrayList<>();
            }
            edgesOfTo.add(fromNode);
            graph.put(toNode, edgesOfTo);
        }
    }

    public static void main(String[] args) {

        int n = 5, discounts = 1;
        //n = 4; discounts = 20;
        int[][] highways = new int[][]{{0,1,4},{2,1,3},{1,4,11},{3,2,3},{3,4,2}};
        //highways = new int[][]{{1,3,17},{1,2,7},{3,2,5},{0,1,6},{3,0,20}};

        System.out.println("Minimum cost :: "+ minimumCost(n, highways, discounts));


    }
}
