package Pbm;

import java.util.Arrays;

public class SubstrPermSrch {
	
	public static void search(char[] txt, char[] pat ) {
		
		System.out.print("Given String - ");
		System.out.print(txt);
		System.out.println();
		System.out.print("Search Pattern - ");
		System.out.print(pat);
		System.out.println();
		
		int patLen = pat.length;
		char P[] = Arrays.copyOf(pat, patLen);
		Arrays.sort(P);
		
		for (int i=0; i <= txt.length - patLen; i++) {
			int toIndex = i + patLen;
			/*if (toIndex <= txt.length) {*/
				char T[] = Arrays.copyOfRange(txt, i, toIndex);
				Arrays.sort(T);
				if (Arrays.equals(P, T)) {
					System.out.println("Found at index :- " + i);
				}
			/*} else {
				break;
			}*/
		}
		
	    
	}
	
	public static void main (String[] args) {
		
		char[] txt = {'B','A','C','D','G','A','B','C','D','A'};
		char[] pat = {'A','B','D','C'};
		search(txt, pat);
	}

}
