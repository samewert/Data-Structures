package PA8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestCorrectness {

	private static String toString(int[] arr, int length) {
		return Arrays.toString(arr);
	}

	private static void testAlphabet() {
		int[] arr = { -5, 10, 45, 13, 89, -18, 34, 78, 23, 25, -5, 13, 78, 101, 89, 25 };
		System.out.printf("Original array is %s\n", toString(arr, arr.length));
		System.out.printf("Alphabet in sorted order is %s\n", Ordered.alphabet(arr, arr.length));
	}

	private static void testZeroSumHelper(int[] arr, int len) {
		int[] zero = Ordered.zeroSumSubArray(arr, len);
		System.out.printf("\n%s", toString(arr, len));
		if (null == zero || 0 == zero.length)
			System.out.printf(" has no subarray whose sum is zero.");
		else
			System.out.printf(" has a subarray from index %d to index %d whose sum is zero.", zero[0], zero[1]);
	}

	private static void testZeroSum() {
		int[] arr1 = { 12, -26, 1, 8, 9, -6, 4, -12, -3, 12 };
		testZeroSumHelper(arr1, arr1.length);
		int[] arr2 = { 1, 7, 19, -14, 1, -14, 12 };
		testZeroSumHelper(arr2, arr2.length);
		int[] arr3 = { 1, 7, 19, -14, 1, -14, 8, 9, -6, 4, -12, -3, 12 };
		testZeroSumHelper(arr3, arr3.length);
		int[] arr4 = { -6, 4, -12, -3, 12 };
		testZeroSumHelper(arr4, arr4.length);
		int[] arr5 = { -6, 4, -12, 0, -3, 12 };
		testZeroSumHelper(arr5, arr5.length);
		int[] arr6 = { 0, -6, 4, -12, -3, 12 };
		testZeroSumHelper(arr6, arr6.length);
		int[] arr7 = { 1, 8, 9, -6, 4, -12, -3 };
		testZeroSumHelper(arr7, arr7.length);
		int[] arr8 = { 1, 8, 9, 0 };
		testZeroSumHelper(arr8, arr8.length);
	}

	private static void testDuplicates() {
		int[] arr1 = { 1, 5, 6, 19, 5, 1, 56, 34, 1, 7, 12, 13, 20 };
		int[] arr2 = { 6, 19, 13, 56, 12, 20, 20, 12, 6 };
		int[] arr3 = { 55, 54, 23, 18, 98 };

		ArrayList<Integer> dup12 = Unordered.findDuplicates(arr1, arr2, arr1.length, arr2.length);
		Collections.sort(dup12);
		ArrayList<Integer> dup13 = Unordered.findDuplicates(arr1, arr3, arr1.length, arr3.length);
		System.out.printf("\n\nDuplicates among %s and %s are %s\n", toString(arr1, arr1.length),
				toString(arr2, arr2.length), dup12);
		System.out.printf("Duplicates among %s and %s are %s\n", toString(arr1, arr1.length),
				toString(arr3, arr3.length), dup13);
	}

	private static void testAnagram() {
		String str1 = "integral";
		String str2 = "triangle";
		System.out.printf("\n%s and %s are anagrams of each other? %s\n", str1, str2,
				Unordered.areAnagrams(str1, str2) ? "YES" : "NO");

		str1 = "integral";
		str2 = "trianglex";
		System.out.printf("%s and %s are anagrams of each other? %s\n", str1, str2,
				Unordered.areAnagrams(str1, str2) ? "YES" : "NO");

		str1 = "integral";
		str2 = "triannle";
		System.out.printf("%s and %s are anagrams of each other? %s\n", str1, str2,
				Unordered.areAnagrams(str1, str2) ? "YES" : "NO");

		str1 = "aabxxb#(cb";
		str2 = "a#xbxa(bcb";
		System.out.printf("%s and %s are anagrams of each other? %s\n", str1, str2,
				Unordered.areAnagrams(str1, str2) ? "YES" : "NO");

		str1 = "aabxxb#(cb";
		str2 = "zzbxxb#(cb";
		System.out.printf("%s and %s are anagrams of each other? %s\n", str1, str2,
				Unordered.areAnagrams(str1, str2) ? "YES" : "NO");

		str1 = "aabxxb#(cb";
		str2 = "aabxxb#acb";
		System.out.printf("%s and %s are anagrams of each other? %s\n", str1, str2,
				Unordered.areAnagrams(str1, str2) ? "YES" : "NO");

		str1 = "aabxxb#(cbfrbt%ybbuuahh##61$$)%";
		str2 = "abbh#abyxbfab%t%bxuu)h(##61c$r$";
		System.out.printf("%s and %s are anagrams of each other? %s\n", str1, str2,
				Unordered.areAnagrams(str1, str2) ? "YES" : "NO");

		str1 = "aabxxb#(cbfrbt%ybbuuahh##61$$)%";
		str2 = "abbh#abyxbfab%t%bxvu)h(##61c$r$";
		System.out.printf("%s and %s are anagrams of each other? %s", str1, str2,
				Unordered.areAnagrams(str1, str2) ? "YES" : "NO");

	}

	public static void main(String[] args) {
		testAlphabet();
		testZeroSum();
		testDuplicates();
		testAnagram();
	}

}
