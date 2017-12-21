package Algo.Searching;

import java.util.Scanner;

import DS.Heap.BinaryHeap;

/*Time Complexity :: O(log k)*/

public class KthLarStream {
	
	static BinaryHeap<Integer> kHeap;
	static int k;
	private static Scanner scanner;
	
	public static void kThLarge() {
		while(true) {
			System.out.println("Enter next element in the stream : ");
			int i = -1;
			scanner = new Scanner(System.in);
			if (scanner.hasNextInt()) {
				i = scanner.nextInt();
			}
			if (i > kHeap.min()) {
				kHeap.list.remove(0);
				kHeap.list.add(0, i);
				kHeap.heapify(0);
			}
			System.out.println("The " + k +"th smallest element is " + kHeap.min());
		}
	}
	
	public static void getKelts() {
		scanner = new Scanner(System.in);
		System.out.println("Enter "+ k +" elements of the stream : ");
		for (int i = 0; i < k ; i++) {
			if (scanner.hasNextInt()) {
				kHeap.insert(scanner.nextInt());
			}
		}
	}
	
	public static void main (String[] args) {
		
		k = 3;
		kHeap = new BinaryHeap<Integer>();
		getKelts();
		kThLarge();
	}
}
