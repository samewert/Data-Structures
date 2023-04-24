package PA6;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericHeap<T> {

	private ArrayList<T> heapArray;
	private Comparator<T> comparator;

	public GenericHeap(Comparator<T> comparator) {
		heapArray = new ArrayList<T>();
		this.comparator = comparator;
	}

	public T top() {
		return heapArray.get(0);
	}

	public void extract() { // complete this method
		swap(0, heapArray.size() - 1);
		heapArray.remove(size() - 1);
		int currentIndex = 0;
		int leftIndex = 1;
		int rightIndex = 2;
		while(leftIndex < heapArray.size()) {
			int minIndex = leftIndex;
			T minKey = heapArray.get(minIndex);
			if(rightIndex < heapArray.size()) {
				T rightKey = heapArray.get(rightIndex);
				if(comparator.compare(rightKey, minKey) < 0) {
					minIndex = rightIndex;
					minKey = rightKey;
				}
			}
			if(comparator.compare(minKey, heapArray.get(currentIndex)) < 0) {
				swap(minIndex, currentIndex);
				currentIndex = minIndex;
			} else {
				break;
			}
			leftIndex = currentIndex * 2 + 1;
			rightIndex = leftIndex + 1;
		}
	}

	public void insert(T value) { // complete this method
		int currentIndex = heapArray.size();
		int parentIndex = (currentIndex - 1) / 2;
		heapArray.add(value);
		while(currentIndex > 0 && (comparator.compare(heapArray.get(parentIndex), heapArray.get(currentIndex)) > 0)) {
			swap(parentIndex, currentIndex);
			currentIndex = parentIndex;
			parentIndex = (currentIndex - 1) / 2;
		}
	}

	private void swap(int index1, int index2) {

		T temp = heapArray.get(index1);
		heapArray.set(index1, heapArray.get(index2));
		heapArray.set(index2, temp);
	}

	public int size() {
		return heapArray.size();
	}
	
	public String toString() {
		return heapArray.toString();
	}
}
