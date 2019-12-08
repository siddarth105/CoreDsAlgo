package Algo.Hashing;

public class AnagramSubstringSearch {
  
    public static void main(String args[]) { 
        String txt = "BACDGABCDA"; 
        String pat = "ABCD";
        
        int[] patVal = new int[txt.length()];
        char[] patChar = pat.toCharArray();
        char[] txtChar = txt.toCharArray();
        for (int i=0; i < txtChar.length; i++) {
	        	System.out.print(txtChar[i]-'A' + " ");	
	        	patVal[i] = txtChar[i]-'A';
        }
    } 
}
