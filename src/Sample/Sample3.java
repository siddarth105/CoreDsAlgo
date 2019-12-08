package Sample;

public class Sample3 {
	
	private static int finalInstances(int instances, int[] averageUtil) {
		long max = 200000000L;
		int skipsecs = 11;
		int i = 0;
		while (i < averageUtil.length) {
			if (averageUtil[i] < 25 && instances != 1) {
				instances = (int) Math.ceil(instances / 2);
				i = i + skipsecs;
			} else if (averageUtil[i] > 75 && instances * 2 < max) {
				instances = instances * 2;
				i = i + skipsecs;
			} else {
				i++;
			}
		}
		return instances;
	}

	public static void main(String[] args) {
		int[] arr = { 25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80 };
		System.out.println(finalInstances(2, arr));

	}

}
