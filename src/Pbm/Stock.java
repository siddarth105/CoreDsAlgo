package Pbm;

/* Qn :: The cost of a stock on each day is given in an array, 
find the max profit that you can make by buying and selling in those days. 
For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, 
the maximum profit can earned by buying on day 0, selling on day 3. 
Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, 
then profit cannot be earned at all.*/

public class Stock {
	
	public static int[] price;

	public static void stkBuySell() {
		int n = price.length;
		int count = 0;
		int i = 0;
		Interval sol[] = new Interval[n/2 + 1];
		for (int k = 0; k < n / 2 + 1; k++) {
			sol[k] = new Interval();
		}
		
		while (i < n - 1) {
			while ((i < n - 1) && (price[i + 1] <= price[i])) {
				i++;
			}
			if (i == n - 1)
				break;

			sol[count].buy = i++;

			// Note that the limit is (n-1) as we are comparing to previous element
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			sol[count].sell = i - 1;
			count++;
		}

		if (count == 0) {
			System.out.println("There is no day when buying the stock will make profit\n");
		} else {
			for (int z = 0; z < count; z++)
				System.out.println("Buy on day: "+ sol[z].buy +" Sell on day: " + sol[z].sell + "\n");
		}

		return;
	}

	public static void main(String[] args) {
		price = new int[] { 100, 180, 260, 310, 40, 535, 695 };
		stkBuySell();
	}

}

/*Algorithm :- 
 Refer PhotoShot
1. Find the local minima and store it as starting index. If not exists, return.
2. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
3. Update the solution (Increment count of buy sell pairs)
4. Repeat the above steps if end is not reached
*/