package PA7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSortedArrays {

	public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> lists) { // complete this function
		PriorityQueue<Element> pq = new PriorityQueue<Element>(new ElementComparator());
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for(int i = 0; i < lists.size(); i++) {
			pq.add(new Element(i, lists.get(i).get(0)));
		}
		int[] indexes = new int[lists.size()];
		for(int i = 0; i < indexes.length; i++) {
			indexes[i] = 1;
		}
		while(pq.size() != 0) {
			Element minElement = pq.remove();
			sortedList.add(minElement.priority);
			int minItem = minElement.item;
			if(indexes[minItem] < lists.get(minItem).size()) {
				pq.add(new Element(minItem, lists.get(minItem).get(indexes[minItem])));
				indexes[minItem]++;
			}
		}
		return sortedList;
	}
}
