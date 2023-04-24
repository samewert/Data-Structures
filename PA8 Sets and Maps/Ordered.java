package PA8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ordered {

	/**
	 * Complete this method that returns the distinct numbers in an array in sorted
	 * order using a TreeSet. You must use a TreeSet. You must achieve O(len * log
	 * (len)) complexity.
	 */
	public static ArrayList<Integer> alphabet(int[] arr, int len) {
		TreeSet<Integer> mySet = new TreeSet<Integer>();
		for(int i = 0; i < len; i++) {
			mySet.add(arr[i]);
		}
		Iterator<Integer> it = mySet.iterator();
		ArrayList<Integer> alphabet = new ArrayList<Integer>();
		while(it.hasNext())
			alphabet.add(it.next());
		return alphabet;
	}

	/**
	 * This method checks if the argument array arr contains a subarray whose sum is
	 * zero. You must use a TreeMap for this method. You must achieve O(len * log
	 * (len)) time. If such a zero array exists, this method will return its start
	 * and end indexes, else return null
	 */
	public static int[] zeroSumSubArray(int[] arr, int len) {
		TreeMap<Integer, Integer> myMap = new TreeMap<Integer, Integer>();
		int prefixSum = 0;
		for(int i = 0; i < len; i++) {
			prefixSum += arr[i];
			if(prefixSum == 0) {
				int[] zeroSum = {0, i};
				return zeroSum;
			}
//			a;soa;sdas;gads;ha;shau;sd;adshg;ashdg;oashdg;uasdh;ah .contains
			if(myMap.containsKey(prefixSum)) {
				Integer val = myMap.get(prefixSum);
				int[] zeroSum = {val + 1, i};
				return zeroSum;
			} else {
				myMap.put(prefixSum, i);
			}
		}
		return null;
	}
}
