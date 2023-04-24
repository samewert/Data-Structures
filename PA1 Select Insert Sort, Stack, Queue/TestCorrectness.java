package PA1;

import java.util.Arrays;

public class TestCorrectness {

	public static void main(String[] args) throws Exception {
		int queueSize = 7;
		QueueUsingStack qViaStack = new QueueUsingStack(queueSize);
		Queue queue = new Queue(queueSize);
		System.out.println("**** Enqueue Test ****");
		System.out.println();
		for (int i = 1; i <= 4; i++) {
			int x = i * 5;
			qViaStack.enqueue(x);
			queue.enqueue(x);
			System.out.println("Enqueue " + x);
			System.out.println("Stack implementation: " + qViaStack.toString());
			System.out.println("Standard implementation: " + queue.toString());
			System.out.println();
		}
		System.out.println("**** Dequeue Test ****");
		System.out.println();
		for (int i = 1; i <= 2; i++) {
			System.out.println("Stack implementation: (Dequeued " + qViaStack.dequeue() + ") " + qViaStack.toString());
			System.out.println("Standard implementation: (Dequeued " + queue.dequeue() + ") " + queue.toString());
			System.out.println();
		}
		System.out.println("**** Enqueue Test ****");
		System.out.println();
		for (int i = 1; i <= 5; i++) {
			int x = i * 7;
			qViaStack.enqueue(x);
			queue.enqueue(x);
			System.out.println("Enqueue " + x);
			System.out.println("Stack implementation: " + qViaStack.toString());
			System.out.println("Standard implementation: " + queue.toString());
			System.out.println();
		}
		System.out.println("**** Dequeue Test ****");
		System.out.println();
		for (int i = 1; i <= 7; i++) {
			System.out.println("Stack implementation: (Dequeued " + qViaStack.dequeue() + ") " + qViaStack.toString());
			System.out.println("Standard implementation: (Dequeued " + queue.dequeue() + ") " + queue.toString());
			System.out.println();
		}

		System.out.println("**** Sorting ****\n");
		int A[] = { 13, 17, 8, 14, 1 };
		System.out.println("Original Array: " + Arrays.toString(A));
		Sorting.selectionSort(A, A.length);
		System.out.println("Selection Sorted Array: " + Arrays.toString(A));

		System.out.println();

		int B[] = { -13, -17, -8, -14, -1, -20 };
		System.out.println("Original Array: " + Arrays.toString(B));
		Sorting.insertionSort(B, B.length);
		System.out.println("Insertion Sorted Array: " + Arrays.toString(B));
	}
}
