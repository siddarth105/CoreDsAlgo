package Pbm;

public class Sort0s1s2s {

	static void sort012(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				//Swap a[l] & a[m]
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				//Swap a[m] & a[h]
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

	static void printArray(int arr[], int arr_size) {
		int i;
		for (i = 0; i < arr_size; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		sort012(arr, arr_size);
		System.out.println("Array after seggregation ");
		printArray(arr, arr_size);
	}
}
