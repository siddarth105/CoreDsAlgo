package Algo.Sorting;

import java.util.Scanner;

public class BubbleSort {

	int arr[], n;

	/*
	 * Sort Logic 
	 * Best :: O(n) 
	 * Avg :: O(n^2) 
	 * Worst :: O(n^2)
	 */
	public void bubleSort() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j);
				}
			}
		}
	}

	public void swap(int[] arr, int j) {
		int temp;
		temp = arr[j];
		arr[j] = arr[j + 1];
		arr[j + 1] = temp;
	}

	public static void main(String[] args) {

		BubbleSort bs = new BubbleSort();
		bs.getInput();
		bs.bubleSort();
		bs.printOutput();
	}

	// Utility Methods
	// Input :: -2 45 0 11 -9

	public void getInput() {
		System.out.println("Enter the number of elements : ");
		Scanner scanIn = new Scanner(System.in);
		n = Integer.parseInt(scanIn.nextLine());
		arr = new int[n];
		System.out.println("Enter the elements : ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(scanIn.nextLine());
		}
		scanIn.close();
		System.out.println("The elements are :");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void printOutput() {
		System.out.println("The sorted elements are : ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
