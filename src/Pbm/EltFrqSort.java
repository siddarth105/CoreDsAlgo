package Pbm;

import java.util.Arrays;
import java.util.Collections;

import CmptrNCmpble.EltCountComp;
import CmptrNCmpble.EltValComp;

public class EltFrqSort {

	static int a[];

	public class Elt {
		public int count, index, val;

		public Elt(int count, int index, int val) {
			this.count = count;
			this.index = index;
			this.val = val;
		}
	}
	
	public static void sort(Elt[] elt) {
		//O(nlogn)
		Collections.sort(Arrays.asList(elt), new EltValComp());
		elt[0].count = 1;

		//O(n)
		for (int i = 1; i < a.length; i++) {
			if (elt[i].val == elt[i - 1].val) {
				elt[i].count += elt[i - 1].count + 1;
				elt[i - 1].count = -1;
				elt[i].index = elt[i - 1].index;
			} else {
				elt[i].count = 1;
			}
		}

		//O(nlogn)
		Collections.sort(Arrays.asList(elt), new EltCountComp());
		for (int i = a.length - 1, index = 0; i >= 0; i--) {
			if (elt[i].count != -1) {
				for (int j = 0; j < elt[i].count; j++) {
					a[index++] = elt[i].val;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		EltFrqSort eltSort = new EltFrqSort();
		a = new int[] { 5, 2, 2, 8, 5, 6, 8, 8 };
		Elt elt[] = new Elt[a.length];
		for (int i = 0; i < a.length; i++) {
			elt[i] = eltSort.new Elt(0, i, a[i]);
		}
		sort(elt);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	/*
	
	ALGORITHM :-
	1) Use a sorting algorithm to sort the elements O(nlogn)    
	2) Scan the sorted array and construct a 2D array of element and count O(n).
	3) Sort the 2D array according to count O(nlogn).
	
	 Input 5  2  2  8  5  6  8  8

	  After sorting we get
	  Element 2 2 5 5 6 8 8 8
	  Index   1 2 0 4 5 3 6 7
	
	  Now construct the 2D array as
	  Index, Count
	  1,      2
	  0,      2
	  5,      1
	  3,      3
	
	  Sort by count (consider indexes in case of tie)
	  3, 3
	  0, 2
	  1, 2
	  5, 1
	  
	  Print the elements using indexes in the above 2D array.
	  
	*/
}
