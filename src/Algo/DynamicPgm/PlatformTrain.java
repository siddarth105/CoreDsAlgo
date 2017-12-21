package Algo.DynamicPgm;

import Algo.Sorting.QuickSort;

public class PlatformTrain {
	
	static int a[];
	static int d[];
	
	public static int findPlatform() {
		QuickSort.a = a;
		QuickSort.quickSort(0, a.length - 1);
		QuickSort.a = d;
		QuickSort.quickSort(0, d.length - 1);
		printElts();
		int i = 1; int j = 0; 
		int count = 1; int result = 1;
		
		while (i < a.length && j < a.length) {
			
			if (d[j] > a[i]) {
				count++;
				i++;
				if (count > result) {
					result = count;
				}
			} else {
				count--;
				j++;
			}
		}
		
		return result;
	}
	
	public static void main (String[] args) {
		a = new int[] { 900, 940, 950, 1100, 1500, 1800 };
		d = new int[] { 910, 1200, 1120, 1130, 1900, 2000};
		System.out.println("Maximum number of platforms required :: " + findPlatform());
	}
	
	public static void printElts() {
		for (int i=0; i < a.length; i++) {
			if (i == 0) {
				System.out.print("Arrival\tDeparture\n");
			}
			System.out.print(a[i] + "\t");
			System.out.print(d[i] + "\n");
		}
	}
	
/*	
	Time     Event Type     Total Platforms Needed at this Time                               
	 9:00       Arrival                  1
	 9:10       Departure                0
	 9:40       Arrival                  1
	 9:50       Arrival                  2
	 11:00      Arrival                  3 
	 11:20      Departure                2
	 11:30      Departure                1
	 12:00      Departure                0
	 15:00      Arrival                  1
	 18:00      Arrival                  2 
	 19:00      Departure                1
	 20:00      Departure                0	*/

}
