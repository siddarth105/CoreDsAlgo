package Pbm;

/*	Do following while left < right
	a) Keep incrementing index left while there are 0s at it
	b) Keep decrementing index right while there are 1s at it
	c) If left < right then exchange arr[left] and arr[right]	*/
public class Sort0s1s {

	void segregate0and1(int arr[], int size) {
		int left = 0, right = size - 1;
		while (left < right) {
			while (arr[left] == 0 && left < right)
				left++;

			while (arr[right] == 1 && left < right)
				right--;

			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
	}

	public static void main(String[] args) {
		Sort0s1s seg = new Sort0s1s();
		int arr[] = new int[] { 0, 1, 0, 1, 1, 1 };
		int i, arr_size = arr.length;

		seg.segregate0and1(arr, arr_size);

		System.out.print("Array after segregation is ");
		for (i = 0; i < 6; i++)
			System.out.print(arr[i] + " ");
	}

}
