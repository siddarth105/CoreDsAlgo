package Algo.DynamicPgm;

//https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
public class EventStagePbm {
	
	public static int getMaxEvents(int arrival[], int duration[]) {

		int end[] = new int[arrival.length];

		for (int z = 0; z < arrival.length; z++) {
			end[z] = arrival[z] + duration[z];
		}

		for (int i = 0; i < arrival.length - 1; i++) {
			for (int j = i + 1; j < arrival.length; j++) {
				if (end[j] < end[i]) {
					int t = end[j];
					end[j] = end[i];
					end[i] = t;
					t = arrival[j];
					arrival[j] = arrival[i];
					arrival[i] = t;
				}
			}

		}

		int count = 1;
		int prevend = 0;
		int currstart = 1;
		
		while(currstart< arrival.length) {
            if(arrival[currstart] >= end[prevend]) {
            	count++;
            	prevend = currstart;
            }
            currstart++;
		}
		
		return count;
	}
	
	public static void main (String[] args) {
		int[] a = new int[] {1, 1, 1, 1, 4};
		int[] d = new int[] {10, 3, 6, 4, 2};
		
		System.out.println("Maximum number of platforms required :: " + getMaxEvents(a, d));
	}
}
