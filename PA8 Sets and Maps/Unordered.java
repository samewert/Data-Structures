package PA8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Unordered {

	/**
	 * Complete this method that returns the duplicates, i.e., the numbers present
	 * in both arr1 and arr2. You must use a HashSet for this method. You must
	 * achieve complexity O(len1 + len2).
	 */
	public static ArrayList<Integer> findDuplicates(int[] arr1, int[] arr2, int len1, int len2) {
		HashSet<Integer> checker = new HashSet<Integer>();
		HashSet<Integer> duplicates = new HashSet<Integer>();
		for(int i = 0; i < len1; i++) {
			checker.add(arr1[i]);
		}
		for(int i = 0; i < len2; i++) {
			if(checker.contains(arr2[i])) {
				duplicates.add(arr2[i]);
			}
		}
		ArrayList<Integer> doubles = new ArrayList<Integer>();
		Iterator<Integer> it = duplicates.iterator();
		while(it.hasNext()) {
			doubles.add(it.next());
		}
		return doubles;
	}

	/**
	 * Complete this method that checks if str1 is an anagram of str2. You must use a
	 * HashMap for this method. You must achieve complexity O(|str1| +
	 * |str2|)
	 */
	
	public static HashMap<Character,Integer> computeFrequencies(String str){
		HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++) {
			if(!myMap.containsKey(str.charAt(i))) {
				myMap.put(str.charAt(i), 1);
			} else {
				int val = myMap.get(str.charAt(i));
				myMap.put(str.charAt(i), val + 1);
			}
		}
		return myMap;
	}
	
	public static boolean areAnagrams(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Integer> str1Map = computeFrequencies(str1);
		HashMap<Character, Integer> str2Map = computeFrequencies(str2);
		for(int i = 0; i < str1.length(); i++) {
			Integer val1 = str1Map.get(str1.charAt(i));
			Integer val2 = str2Map.get(str1.charAt(i));
			if(val1 != val2) {
				return false;
			}
		}
		return true;
	}
}
