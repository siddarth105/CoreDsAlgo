package Pbm;

import java.util.Stack;

public class MaxVldSubStr {
	
	/*		Input : ((()
			Output : 2
			Explanation : ()

			Input: )()())
			Output : 4
			Explanation: ()() 

			Input:  ()(()))))
			Output: 6
			Explanation:  ()(())	*/
	
	
	public static void main (String[] args) {
		
		String givenStr = "()(()))))";
		char[] gvnChr = givenStr.toCharArray();
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(-1); //The first element of stack is a special element that provides index before beginning of valid substring
		Integer result = 0;
		
		for (int i = 0; i < gvnChr.length; i++) {
			
			if (gvnChr[i] == '(') {
				stk.push(i);
			}
			
			if (gvnChr[i] == ')') {
				// Remove the current '(' pos from stack
				stk.pop();
				if (!stk.isEmpty()) {
					Integer lastVal = i-stk.peek(); // Sub from prev '(' pos
					if (lastVal > result) {
						result = lastVal;
					}
				} else {
					//Pattern not formed -> update the base to some temp value
					stk.push(i);
				}
				
			}
		}
		
		System.out.println("Result :: "  + result);
		
	}
}