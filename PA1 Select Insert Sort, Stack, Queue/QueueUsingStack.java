package PA1;

public class QueueUsingStack {

	Stack mainStack;
	int maxQueueSize;

	public QueueUsingStack(int maxQueueSize) {
		this.maxQueueSize = maxQueueSize;
		mainStack = new Stack(maxQueueSize);
	}

	public void enqueue(int val) { // complete this method
		Stack tempStack = new Stack(maxQueueSize);
		int currentStackSize = mainStack.size();
		for(int i = 0; i < currentStackSize; i++) {
			tempStack.push(mainStack.pop());
		}
		mainStack.push(val);
		for(int i = 0; i < currentStackSize; i++) {
			mainStack.push(tempStack.pop());
		}
	}

	public int dequeue() { // complete this method
		return mainStack.pop();
	}

	public int size() { // complete this method
		return mainStack.size();
	}

	public String toString() {
		if (size() == 0) {
			return "[]";
		} else {
			String output = "[";
			int n = size();
			for (int i = 0; i < n - 1; i++) {
				int x = dequeue();
				output += x + ", ";
				enqueue(x);
			}
			int x = dequeue();
			output += x + "]";
			enqueue(x);
			return output;
		}
	}
}
