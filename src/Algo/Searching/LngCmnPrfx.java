package Algo.Searching;


//http://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/
//Wrong Prg
public class LngCmnPrfx {
	
	/*static String[] s = {"the", "th", "their", "thy"};*/
	static String[] s = {"geeksforgeeks", "geeks",
            "geek", "geezer"};
	
	public static void main(String[] args) {
		int shtStrLen = s[0].length();
		for (String k : s) {
			if(k.length() < shtStrLen){
				shtStrLen = k.length();
			}
		}
		
		binSrch(0, shtStrLen-1);
	}
	
	public static void binSrch(int st, int end){
		
		int lw = 0, high = end;
		String prefix = "";
		
		while (lw <= high) {
			int mid = lw + (high - lw) / 2;
			
			int subEnd = mid - lw + 1;
			
			if (high - lw <= 1) {
				subEnd = high + 1;
			}
			
			String c =  s[0].substring(lw, subEnd);

			if (allContainsPrefix(c, lw, subEnd)) {
				prefix = prefix + s[0].substring(lw, subEnd);
				lw = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		System.out.println(prefix);
	}
	
	public static boolean allContainsPrefix(String val, int lw, int subEnd){
		
		for (String k : s) {
			if (!val.equals(k.substring(lw, subEnd))) {
				return false;
			}
		}
		
		return true;
	}

}
