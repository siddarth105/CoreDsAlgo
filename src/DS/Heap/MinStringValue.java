package DS.Heap;

import java.util.*;

// https://leetcode.com/problems/replace-question-marks-in-string-to-minimize-its-value/description/?envType=problem-list-v2&envId=heap-priority-queue&difficulty=MEDIUM
public class MinStringValue {
    public static class Elt {
        char val;
        int freq;
        int lexOrder;
        public Elt(char val, int freq, int lexOrder){
            this.val = val;
            this.freq = freq;
            this.lexOrder =lexOrder;
        }

        public char getVal() {
            return val;
        }

        public int getFreq() {
            return freq;
        }

        public int getLexOrder() {
            return lexOrder;
        }
    }

    public static void minimiseString (char[] input) {
        Comparator<Elt> freqComparator = Comparator.comparing(Elt :: getFreq);
        Comparator<Elt> lexComparator = Comparator.comparing(Elt :: getLexOrder);
        PriorityQueue<Elt> minHeap = new PriorityQueue<Elt>(freqComparator.thenComparing(lexComparator));
        Map<Character, Elt> eltMap = new HashMap<Character, Elt>();

        // Add all characters from 'a' to 'z' with freq 0 and corresponding lexicographic order
        initializePriorityQueue(minHeap, eltMap);

        int count = 0;
        for (char c : input) {
            if ('?' != c) {
                Elt elt = eltMap.get(c);
                elt.freq += 1;
                minHeap.remove(elt);
                minHeap.add(elt);
            } else {
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            Elt minimum = minHeap.poll();
            System.out.println("Elt = "+minimum.val);
        }

    }

    private static void initializePriorityQueue(PriorityQueue<Elt> minHeap, Map<Character, Elt> eltMap) {
        for (char c = 'a'; c <= 'z'; c++) {
            Elt elt = new Elt(c, 0, c - 'a' + 1);
            minHeap.add(elt);
            eltMap.put(c, elt);
        }
    }

    public static void main(String[] args) {
        // a -> z, ?, ?, a, d
        char[] input = initializeInput();
        minimiseString(input);
    }

    private static char[] initializeInput() {
        char[] input = new char[30];
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            input[index++] = c;
        }
        input[index++] = '?';
        input[index++] = '?';
        input[index++] = 'a';
        input[index++] = 'd';
        return input;
    }
}
