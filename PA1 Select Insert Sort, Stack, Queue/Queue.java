package PA1;

public class Queue {

	private int maxQueueSize, front, rear, currentSize;
	private int[] queue;

	public Queue(int maxQueueSize) {
		if (maxQueueSize <= 0)
			System.out.println("Queue size should be a positive integer.");
		else {
		this.maxQueueSize = maxQueueSize;
		front = rear = 0; 
		currentSize = 0;
		queue = new int[maxQueueSize];
		}
	}

	public void enqueue(int val) { // complete this method
		if(currentSize == maxQueueSize) 
			System.out.println("Queue full. Cannot queue.");
		else {
			queue[rear++] = val;
			currentSize++;
			if(rear == maxQueueSize)
				rear = 0;
		}
	}

	public int dequeue() { // complete this method
		if(0 == currentSize) {
			System.out.println("Queue is empty. Cannot dequeue.");
			return Integer.MIN_VALUE;
		}
		int temp = queue[front++];
		currentSize--;
		if(front == maxQueueSize) 
			front = 0;
		return temp;
	}

	public int size() { // complete this method
		return currentSize;
	}

	public String toString() {
		if (size() == 0)
			return "[]";
		else {
			String output = "[";
			if (rear > front) {
				for (int i = front; i < rear - 1; i++)
					output += queue[i] + ", ";
				output += queue[rear - 1] + "]";
			} else {
				for (int i = front; i < maxQueueSize - 1; i++)
					output += queue[i] + ", ";
				output += queue[maxQueueSize - 1];

				for (int i = 0; i < rear; i++)
					output += ", " + queue[i];
				output += "]";
			}
			return output;
		}
	}
}
