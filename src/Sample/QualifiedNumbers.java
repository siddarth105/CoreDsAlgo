package Sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QualifiedNumbers {
	
	
	static String findQualifiedNumbers(int[] numberArray) {
        
        int[] a = numberArray;
        List<Integer> qualifiedElements = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
          if(checkDigitsUsingSet(a[i], 1)) {
            qualifiedElements.add(a[i]);
          }
        }

        Collections.sort(qualifiedElements);
        if(qualifiedElements.size() == 0) {
          return "-1";
        }
        if(qualifiedElements.size() == 1) {
          return qualifiedElements.get(0).toString();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < qualifiedElements.size() - 1; i++) {
          sb.append(qualifiedElements.get(i));
          sb.append(',');
        }
        sb.append(qualifiedElements.get(qualifiedElements.size() - 1));
        return sb.toString();

    }


    static boolean checkDigitsUsingSet(int number) {

        number = Math.abs(number);
        List<Integer> digits = new ArrayList<>();

        while(number > 0) {
          digits.add(number % 10);
          number /= 10;
        }

        int first;
        int second;
        int third;
        for(int i = 0; i < digits.size(); i++) {
          if(i + 2 < digits.size()) {
            first = digits.get(i);
            second = digits.get(i + 1);
            third = digits.get(i + 2);
            int result = 1 << first | 1 << second | 1 << third;
            if(result == 14){
              return true;
            }
          }
        }
        return false;
    }
    
    
    static boolean checkDigitsUsingSet(int number, int z) {

        number = Math.abs(number);
        List<Integer> digits = new ArrayList<>();

        while(number > 0) {
          digits.add(number % 10);
          number /= 10;
        }
        boolean first = false;
        boolean second = false;
        boolean third = false;
        for(int i = 0; i < digits.size(); i++) {
	        	if (digits.get(i) == 1)
	        		first = true;
	        	if (digits.get(i) == 2)
	        		second = true;
	        	if (digits.get(i) == 3)
	        		third = true;
          }
        return first && second && third;
    }
    
    
    public static void main (String[] args) {
	    	int[] numberArray = {2, 1223, 1231};
	    	System.out.println(findQualifiedNumbers(numberArray));
    }

}
