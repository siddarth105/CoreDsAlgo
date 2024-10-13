package DS.Stack;

import java.util.Stack;

public class StackMergeSort {
	
	/*Algorithm:-

	1)	Split:-
		
		Pivot -> Last elt in Stack
		Smaller-Bucket -> Left
		Bigger-Bucket -> Right
		
	2)	Repeat for Smaller-Bucket till it(left) becomes empty -> Recursion
	3)	Repeat for Bigger-Bucket till it(right) becomes empty -> Recursion
										
	4)	After Recursion -> Do the reverse
			Merge
			Push bigger 1) Bigger-Bucket -> Right
						2) Pivot
						3) Smaller-Bucket -> Left */
	
	
	public static Stack<Integer> sort(Stack<Integer> s) {

		if (s.isEmpty()) {
			return s;
		}

		int pivot = s.pop();
		Stack<Integer> right = new Stack<Integer>();
		Stack<Integer> left = new Stack<Integer>();
		
		// Split
		while (!s.isEmpty()) {
			int y = s.pop();
			if (pivot < y) {
				right.push(y);
			} else {
				left.push(y);
			}
		}
		
		// Recurse
		sort(left);
		sort(right);

		// Merge
		Stack<Integer> tmp = new Stack<Integer>();
		while (!right.isEmpty()) {
			tmp.push(right.pop());
		}
		tmp.push(pivot);
		while (!left.isEmpty()) {
			tmp.push(left.pop());
		}
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		return s;

	}

	public static void main(String[] args) {

		Stack<Integer> s = new Stack<Integer>();

		s.push(2);
		s.push(10);
		s.push(40);
		s.push(1);
		s.push(99);
		s.push(9);
		s.push(90);
		s.push(50);
		s.push(8);
		s.push(12);

		sort(s);

		while (!s.isEmpty()) {
			System.out.println("" + s.pop());
		}

	}

}
