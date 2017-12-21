package Pbm;

public class RainWaterTrapping {
	
	
	//Refer screen shot
	
	static int arr[];
	
	public static int findwater() {
		
		int n = arr.length;
		int[] left = new int[n]; 
		int[] right = new int[n];
		int water = 0;
		
		left[0] = arr[0];
	    for (int i = 1; i < n; i++)
	       left[i] = Math.max(left[i-1], arr[i]);
	    
	    right[n-1] = arr[n-1];
	    for (int j = n-2; j >= 0; j--)
	    	right[j] = Math.max(right[j+1], arr[j]);
		
	    for (int i = 0; i < n; i++)
	        water += Math.min(left[i],right[i]) - arr[i];
	  
	    return water;
	}
	
	
	public static int trap() {

		if (arr == null || arr.length == 0)
			return 0;

		int leftMax = 0, rightMax = 0, max = 0;
		int right = arr.length - 1;
		int left = 0;
		while (left < right) {
			leftMax = leftMax > arr[left] ? leftMax : arr[left];
			rightMax = rightMax > arr[right] ? rightMax : arr[right];
			int minVal = 0;
			if (leftMax < rightMax) {
				minVal = leftMax - arr[left];
				left++;
			} else {
				minVal = rightMax - arr[right];
				right--;
			}
			max = max + minVal;
		}
		return max;
	}
	
	
	
	public static void main (String[] args) {
		
		/*arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};*/
		arr = new int[]{3, 0, 0, 2, 0, 4};
		System.out.println("The amount of water trapped is : "+ trap());
	}
}
