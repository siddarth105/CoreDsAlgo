package Algo.Sorting;

import java.util.Scanner;

public class HeapSort {

	int arr[], n;
	
	/*
	 * Sort Logic 
	 * Best :: O(nlogn) 
	 * Avg :: O(nlogn) 
	 * Worst :: O(nlogn)
	 */
	public void buildHeap() {
        for (int i = (int)(arr.length / 2); i >= 0; i--) {
            heapify(i);
        }
    }
	
	private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < arr.length && arr[l] < arr[i]) {
            smallest = l;
        }
        if (r < arr.length && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(arr, i, smallest);
            heapify(smallest);
        }
    }
	
	private void swap(int[] arr, int i, int smallest) {
		int tmp = arr[i];
        arr[i] = arr[smallest];
        arr[smallest] = tmp; 
    }
	
	private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
	
	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
		hs.getInput();
		hs.buildHeap();
		hs.printOutput();
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
