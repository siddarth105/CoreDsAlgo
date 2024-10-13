package Algo.DFS;

// https://practice.geeksforgeeks.org/problems/alien-dictionary/1
// https://interviewing.io/questions/alien-dictionary

// ALGORITHM :: TOPOLOGICAL SORTING

/*1. Iterate through each pair of words in the dictionary
2. Construct a Graph Map<String, List<String>>, with key as the element which comes first and values as the list of elements which comes after it
3. Count the number of incoming edges for each node
4. Add the nodes to Priority Queue sorted on incoming node count
5. Poll the element from the QUEUE, print it if incoming node count is '0', find the neighbours from the graph and decrement the node count
6. Return -1, if there are elements in the queue with incoming edge more than 1
7. Return -1, if there is a cycle in the graph*/
public class AlienDictionary {
}
