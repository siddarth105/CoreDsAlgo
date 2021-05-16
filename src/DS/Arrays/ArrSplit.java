package DS.Arrays;

public class ArrSplit {
	
	static int findSplitPoint(int arr[]) { 
	     int leftSum = 0; 
	     for (int i = 0 ; i < arr.length ; i++) { 
	         leftSum += arr[i]; 
	     }
	     int rightSum = 0; 
	     int index = -1;
	     for (int i = arr.length-1; i >= 0; i--) {     
	         rightSum += arr[i]; 
	         leftSum -= arr[i]; 
	         if (rightSum == leftSum) {
	        	 	index = Math.min(index,i);
	        	 	System.out.println("index :: " + index + " , i :: " + i); 
	             return i ; 
	         }
	     } 
	     return index; 
	   } 
	 
	   
	   static int printTwoParts(int arr[]) { 
	
	       int splitPoint = findSplitPoint(arr);      
	       if (splitPoint == -1 || splitPoint == arr.length ) { 
	           System.out.println("Not Possible" ); 
	           return 0; 
	       } 
	       return splitPoint;
	   } 
	    
    public static int solution(int[] A, int[] B) {
        
        int splitPointA = printTwoParts(A);
        if (splitPointA == 0) {
            return 0;
        }
        int splitPointB = printTwoParts(B);
        
        if (splitPointA == splitPointB) {
            
            int sumA = 0; int sumB = 0;
            for (int i = 0; i < A.length; i++) { 
               if(splitPointA == i) 
                   break;   
                sumA += A[i];
            } 
            for (int i = 0; i < B.length; i++) { 
               if(splitPointB == i) 
                   break;   
                sumB += B[i];
            } 
            
            if (sumA == sumB) {
            		System.out.println("splitPointA :: " + splitPointA);
                return splitPointA;
            }
        }
        return 0;
    }
	    
    public static void main (String[] args) {
    	
    	int[] A = new int[]{2, -2, -3, 3};
    	int[] B = new int[]{0, 0, 4, -4};
	    	//int[] A = new int[]{1, 4, 2, -2, 5}; 
	    	//int[] B = new int[]{7, -2, -2, 2, 5}; 1
		System.out.println(solution(A, B));
    }
}
