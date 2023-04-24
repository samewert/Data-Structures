package PA3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestCorrectness {

	final static int insertionArray[] = { 11, 12, 15, 17, 12, 19, 4, 5, 11, 19, 20, 32, 77, 65, 66, 88, 99, 10, 8, 19,
			15, 66, 11, 19 };
	final static int numInsert = insertionArray.length;

	final static int searchArray[] = { 29, 3, 19, 27, 12, 34, 4, 5, 19, 20, 32, 45, 37, 25, 99, 25, 8, 24, 12, 16 };
	final static int numSearch = searchArray.length;

	final static int deleteArray[] = { 16, 12, 15, 5, 17, 19, 4, 5, 19, 20, 32, 17, 19, 39, 99, 10, 8, 19, 15, 21 };
	final static int numDelete = deleteArray.length;

	final static int[] cleanUp = { 11, 77, 65, 66, 88 };
	final static int numCleanUp = cleanUp.length;
	
	final static int TABLE_SIZE = 7;

	private static void printList(final List<Integer> list) {
		if (list.size() == 0) {
			System.out.print("[]");
			return;
		}
		Iterator<Integer> it = list.iterator();
		System.out.print("[");
		for (int i = 0; i < list.size() - 1; i++)
			System.out.print(it.next() + ", ");
		System.out.print(it.next() + "]");
	}

	public static Hashing testHashing() throws Exception {

		System.out.println("****************** Test Hashing Correctness ******************\n");
		Hashing hChain = new Hashing(TABLE_SIZE);

		System.out.println("Inserting the following numbers: " + Arrays.toString(insertionArray));

		for (int i = 0; i < numInsert; i++) 
			hChain.insert(insertionArray[i]);

		System.out.println("\n*** Hash Table Structure (after insertion) ***");
		int size = 0;
		for (int i = 0; i < TABLE_SIZE; i++) {
			System.out.print("Slot " + i + ": ");
			printList(hChain.getList(i));
			System.out.println();
			size += hChain.getList(i).size();
		}
		System.out.println("\nSize of hash table: " + size);

		System.out.println("\n*** Searching Hash Table ***");
		LinkedList<Integer> foundList = new LinkedList<Integer>();
		LinkedList<Integer> notFoundList = new LinkedList<Integer>();

		for (int i = 0; i < numSearch; i++) {
			int val = searchArray[i];
			if (hChain.search(val))
				foundList.add(val);
			else
				notFoundList.add(val);
		}
		System.out.print("Found: ");
		printList(foundList);
		System.out.println();
		System.out.print("Did not find: ");
		printList(notFoundList);
		System.out.println();

		System.out.print("\n*** Deleting Hash Table ***");

		LinkedList<Integer> deleteList = new LinkedList<Integer>();
		notFoundList = new LinkedList<Integer>();
		System.out.println();
		for (int i = 0; i < numDelete; i++) {
			int val = deleteArray[i];
			if (hChain.remove(val))
				deleteList.add(val);
			else
				notFoundList.add(val);
		}
		System.out.print("Deleted: ");
		printList(deleteList);
		System.out.println();
		System.out.print("Did not find: ");
		printList(notFoundList);
		System.out.println();

		System.out.println("\n*** Hash Table Structure (after deletion) ***");
		size = 0;
		for (int i = 0; i < TABLE_SIZE; i++) {
			System.out.print("Slot " + i + ": ");
			printList(hChain.getList(i));
			System.out.println();
			size += hChain.getList(i).size();
		}
		System.out.println("\nSize of hash table: " + size);
		return hChain;
	}

	private static BST testBST() {
		System.out.println("\n****************** Test BST Correctness ******************\n");

		BST bst = new BST();

		System.out.println("Inserting the following numbers: " + Arrays.toString(insertionArray));

		for (int i = 0; i < numInsert; i++) {
			bst.insert(insertionArray[i]);
		}

		System.out.println("\n*** BST Structure (after insertion) ***");
		bst.print();
		System.out.println("\n\nSize of BST: " + bst.getSize());

		System.out.println("\n*** Searching BST ***");
		LinkedList<Integer> foundList = new LinkedList<Integer>();
		LinkedList<Integer> notFoundList = new LinkedList<Integer>();

		for (int i = 0; i < numSearch; i++) {
			int val = searchArray[i];
			if (bst.search(val) != null)
				foundList.add(val);
			else
				notFoundList.add(val);
		}
		System.out.print("Found: ");
		printList(foundList);
		System.out.println();
		System.out.print("Did not find: ");
		printList(notFoundList);
		System.out.println();

		System.out.print("\n*** Deleting BST ***");

		LinkedList<Integer> deleteList = new LinkedList<Integer>();
		notFoundList = new LinkedList<Integer>();
		System.out.println();
		for (int i = 0; i < numDelete; i++) {
			int val = deleteArray[i];
			if (bst.remove(val))
				deleteList.add(val);
			else
				notFoundList.add(val);
		}
		System.out.print("Deleted: ");
		printList(deleteList);
		System.out.println();
		System.out.print("Did not find: ");
		printList(notFoundList);
		System.out.println();

		System.out.println("\n*** BST Structure (after deletion) ***");
		bst.print();
		System.out.println("\n\nSize of BST: " + bst.getSize());
		return bst;
	}

	private static void cleanTest(Hashing hashing, BST bst) {
		System.out.println("\n****************** Clean up ******************");
		for (int i : cleanUp) {
			hashing.remove(i);
			bst.remove(i);
		}
		int size = 0;
		for (int i = 0; i < TABLE_SIZE; i++) 
			size += hashing.getList(i).size();
		
		System.out.println("\nSize of hash table: " + size);
		System.out.print("Size of BST: " + bst.getSize());
	}

	public static void main(String[] args) throws Exception {
		cleanTest(testHashing(), testBST());
	}
}
