package DS.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.PriorityQueue;

// https://leetcode.com/problems/parallel-courses-ii/description/
// https://leetcode.com/problems/parallel-courses-ii/solutions/708164/java-topological-sort-priorityqueue-of-outdegrees/
public class ParallelCourses {

    class Node {
        int id;
        int inDegree;
        int outDegree;
        List<Node> successors;

        Node(int id) {
            this.id = id;
            this.inDegree = 0;
            this.outDegree = 0;
            this.successors = new ArrayList<>();
        }

        void addSuccessor(Node next) {
            successors.add(next);
            this.outDegree++;
            next.inDegree++;
        }
    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        // Step 1: Create all nodes
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodeMap.put(i, new Node(i));
        }

        // Step 2: Build edges — degrees auto-updated inside addSuccessor()
        for (int[] rel : relations) {
            Node prev = nodeMap.get(rel[0]);
            Node next = nodeMap.get(rel[1]);
            prev.addSuccessor(next);
        }

        // Step 3: Max-heap by outDegree — prioritize courses that unlock the most
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.outDegree - a.outDegree);

        for (Node node : nodeMap.values()) {
            if (node.inDegree == 0) pq.offer(node);
        }

        int semesters = 0;

        while (!pq.isEmpty()) {
            // Step 4: Take up to k courses this semester
            List<Node> taken = new ArrayList<>();
            for (int i = 0; i < k && !pq.isEmpty(); i++) {
                taken.add(pq.poll());
            }

            // Step 5: Unlock successors
            for (Node course : taken) {
                for (Node next : course.successors) {
                    next.inDegree--;
                    if (next.inDegree == 0) pq.offer(next);
                }
            }

            semesters++;
        }

        return semesters;
    }
}
