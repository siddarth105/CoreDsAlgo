package Algo.Hashing;

import java.util.LinkedHashMap;
import java.util.Map;
/* QN :: Find the sub array with the given sum
 * Time Complexity :: O(n)*/
public class SubArraySum {
	
	public static void printSubArr(int[] a, int sum) {
		Map<Integer, Integer> hMap  = new LinkedHashMap<Integer, Integer>();
		int cur_sum = 0;
		for (int i = 0; i < a.length; i++) {
			
			cur_sum = cur_sum + a[i];
			if (sum == cur_sum) {
				System.out.println("Sum "+ sum +", found between indices 0 and " + i);
				return;
			}

			if (hMap.containsKey(cur_sum - sum)) {
				System.out.println("Sum "+ sum +", found between indices "+ (hMap.get((cur_sum - sum))+1) +" and " + i);
				return;
			}
			hMap.put(cur_sum, i);
		}
		System.out.println("Sum cant be found");
	}
	
	public static void main(String[] args) {
		int a[] = {10, 2, -2, -20, 10};
		int sum = -12;
		printSubArr(a, sum);
	}

}
