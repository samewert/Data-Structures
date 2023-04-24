package PA7;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class HeapSort {

	public static void sort(int[] arr, int len) {

		PriorityQueue<Element> heap = new PriorityQueue<Element>(new ElementComparator()); // creates a priority queue using the PriorityQueueComparator

		for (int i = 0; i < len; i++)
			heap.add(new Element(arr[i], arr[i])); // for plain heap sort, item and priority is the same;

		int i = 0;
		while (heap.size() > 0) { // as long as the heap is not empty
			Element ele = heap.remove(); // get the topmost item and remove it
			arr[i++] = ele.item; // could also use ele.priority
		}
	}

	public static void main(String[] args) {
		Random rand = new Random(0);
		int n = 10;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = rand.nextInt(500);
		System.out.println("Original array: " + Arrays.toString(arr));
		sort(arr, n);
		System.out.println("After sorting:  " + Arrays.toString(arr));
	}

}
