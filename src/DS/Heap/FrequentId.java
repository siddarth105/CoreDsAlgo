package DS.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/most-frequent-ids/description/?envType=problem-list-v2&envId=heap-priority-queue&difficulty=MEDIUM
public class FrequentId {

    public static class Elt {
        int id;
        int count;

        public Elt(int id, int count) {
            this.id = id;
            this.count = count;
        }
    }

    public static int[] mostFreqIds (int[] ids, int[] freq) {
        int[] ans = new int[ids.length];
        PriorityQueue<Elt> pq = new PriorityQueue<Elt>(new Comparator<Elt>() {
            @Override
            public int compare(Elt o1, Elt o2) {
                return o2.count - o1.count;
            }
        });
        Map<Integer, Elt> idsMap = new HashMap<>();

        for (int i=0; i< ids.length; i++) {
            Elt elt;
            if (idsMap.containsKey(ids[i])) {
                elt = idsMap.get(ids[i]);
                elt.count = elt.count + freq[i];
                pq.remove(elt);
            } else {
                elt = new Elt(ids[i], freq[i]);
                idsMap.put(ids[i], elt);
            }
            pq.add(elt);

            if (!pq.isEmpty()) {
                ans[i] = pq.peek().count;
                System.out.println("i="+i+", highest_count="+ans[i]);
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] ids = {2,3,2,1,18, 9};
        int[] freq = {3,2,-3,1,2, 5};
        /*int[] ids = {2,3,8,1};
        int[] freq = {3,2,5,1};*/

        mostFreqIds(ids, freq);
    }
}
