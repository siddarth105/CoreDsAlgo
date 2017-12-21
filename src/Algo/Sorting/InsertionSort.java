package Algo.Sorting;

import java.util.Scanner;

public class InsertionSort {

	int arr[], n;
	
	/*
	 * Sort Logic 
	 * Best :: O(n) 
	 * Avg :: O(n^2) 
	 * Worst :: O(n^2)
	 */
	public void insertionSort() {
		for (int i = 1; i < n ; i++) {
			int temp = arr[i];
			int j = i-1;
			while(j >= 0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {
		
		InsertionSort ins = new InsertionSort();
		ins.getInput();
		ins.insertionSort();
		ins.printOutput();
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
