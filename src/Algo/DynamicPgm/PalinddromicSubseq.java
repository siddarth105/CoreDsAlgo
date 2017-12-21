package Algo.DynamicPgm;

public class PalinddromicSubseq {

	static int maxPalSubs(String s, int left, int right) {
		if (left > right)
			return 0;
		if (left == right)
			return 1;
		if (s.charAt(left) == s.charAt(right))
			return maxPalSubs(s, left + 1, right - 1) + 2;
		int ltRes = maxPalSubs(s, left + 1, right);
		int rtRes = maxPalSubs(s, left, right - 1);
		if (ltRes > rtRes) {
			return ltRes;
		}

		return rtRes;
	}

	public static void main(String[] args) {

		String s = "acdapmpomp";
		
		if (null != s && !s.isEmpty()) {
			if (s.length() == 1) {
				System.out.println("Max Val :: " + 1);
			} else {
				int max = 1;
				int cur_max = 1;
				for (int i = 2; i < s.length(); i++) {
					String x = s.substring(0, i);
					int a = maxPalSubs(x, 0, x.length()-1);
					System.out.println("x :: "+ x +" a :: " + a);
					String y = s.substring(i, s.length());
					int b = maxPalSubs(y, 0, y.length()-1);
					System.out.println("y :: "+ y +" b :: " + b);
					
					cur_max = a * b;
					
					if (cur_max > max) {
						max = cur_max;
						System.out.println("cur_max :: " + cur_max);
					}

					System.out.println("Max Val :: " + max);
				}
			}
		} else {
			System.out.println("Max Val :: " + 0);
		}
	}

}
