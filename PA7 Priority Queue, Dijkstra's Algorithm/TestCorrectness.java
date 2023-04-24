package PA7;

import java.util.ArrayList;
import java.util.Arrays;

public class TestCorrectness {

	static final String DIJKSTRA1 = "src/PA7/dijkstra1.txt";
	static final String DIJKSTRA2 = "src/PA7/dijkstra2.txt";

	private static ArrayList<ArrayList<Integer>> arraysToLists(int[][] arrays, int arrayLengths[], int n) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>(n);
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>(arrayLengths[i]);
			for (int j = 0; j < arrayLengths[i]; j++)
				list.add(arrays[i][j]);
			lists.add(list);
		}
		return lists;
	}

	private static void testKSortedMerge() {
		System.out.println("*** Test Merging k Sorted Arrays ***\n");
		int list0[] = { 1, 5, 9, 18 };
		int list1[] = { -10, 5, 18, 67, 100 };
		int list2[] = { -12, -9, -6, 0, 1, };
		int list3[] = { -65, -32, 10, };
		int list4[] = { 1, 19, 45, 67 };
		int lists[][] = { list0, list1, list2, list3, list4 };
		int k = lists.length;
		int eachListLength[] = new int[k];
		for (int i = 0; i < k; i++)
			eachListLength[i] = lists[i].length;
		ArrayList<Integer> mergedList = MergeSortedArrays.kWayMerge(arraysToLists(lists, eachListLength, k));
		System.out.println("Original sorted arrays");
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(lists[i]));
		System.out.println("\nFinal merged array:" + mergedList + "\n");

		k = 4;
		eachListLength = new int[k];
		for (int i = 0; i < k; i++)
			eachListLength[i] = lists[i].length;
		mergedList = MergeSortedArrays.kWayMerge(arraysToLists(lists, eachListLength, k));
		System.out.println("Original sorted arrays");
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(lists[i]));
		System.out.println("\nFinal merged array:" + mergedList + "\n");

		k = 2;
		eachListLength = new int[k];
		for (int i = 0; i < k; i++)
			eachListLength[i] = lists[i].length;
		mergedList = MergeSortedArrays.kWayMerge(arraysToLists(lists, eachListLength, k));
		System.out.println("Original sorted arrays");
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(lists[i]));
		System.out.println("\nFinal merged array:" + mergedList + "\n");

		k = 1;
		eachListLength = new int[k];
		for (int i = 0; i < k; i++)
			eachListLength[i] = lists[i].length;
		mergedList = MergeSortedArrays.kWayMerge(arraysToLists(lists, eachListLength, k));
		System.out.println("Original sorted arrays");
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(lists[i]));
		System.out.println("\nFinal merged array:" + mergedList);
	}

	private static void testDijkstra() throws Exception {
		String filePaths[] = { DIJKSTRA1, DIJKSTRA2 };
		for (int j = 0; j < filePaths.length; j++) {
			System.out.println("\n*** Test Dijkstra (" + filePaths[j] + ") ***");
			Dijkstra dijk = new Dijkstra(filePaths[j]);
			for (int i = 0; i < dijk.numVertices; i++) {
				dijk.executeDijkstra(i);
				System.out.println("\nDistance array (from v" + i + "): "
						+ Arrays.toString(dijk.distance).replaceAll("" + Integer.MAX_VALUE, "infty"));
				System.out.println("Parent array (from v" + i + "):   "
						+ Arrays.toString(dijk.parent).replaceAll("" + Integer.MAX_VALUE, "infty"));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		testKSortedMerge();
		testDijkstra();
	}
}
