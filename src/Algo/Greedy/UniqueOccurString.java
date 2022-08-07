package Algo.Greedy;
import java.util.*;
// https://www.geeksforgeeks.org/minimum-characters-required-to-be-removed-to-make-frequency-of-each-character-unique/
// Time Complexity:O(N) 
// Auxiliary Space:O(256)

public class UniqueOccurString {
	
	public int solution(String S) {
		
		char[] str = S.toCharArray();
		Map<Character,Integer> mp = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		int cntChar = 0;
		for (int i = 0; i < S.length(); i++) {
		  if(mp.containsKey(str[i])) {
		    mp.put(str[i],
		    mp.get(str[i]) + 1);
		  } else {
		    mp.put(str[i], 1);
		  }
		}

		for (Map.Entry<Character,Integer> it : mp.entrySet()) {
		  pq.add(it.getValue());
		}
		
		while (!pq.isEmpty()) {
		  int frequent = pq.peek();
		  pq.remove();
		  if (pq.isEmpty()) {
		    return cntChar;
		  }
		
		  if (frequent == pq.peek()) {
		    if (frequent > 1) {
		      pq.add(frequent - 1);
		    }
		    cntChar++;
		  }
		}

		return cntChar;
   }

	public static void main(String[] args) {
		UniqueOccurString v = new UniqueOccurString(); //ceabaacb, ccaaffddecee
		System.out.println("Number of deletions :: " + v.solution("ccaaffddecee"));
	}

}
