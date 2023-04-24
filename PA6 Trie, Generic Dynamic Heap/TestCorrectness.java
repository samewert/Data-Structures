package PA6;

import java.util.ArrayList;
import java.util.Arrays;

public class TestCorrectness {
	
	static final String STUDENT_PATH = "src/PA6/student.txt";

	private static void testTrie() {
		System.out.println("*** Test Trie (Spell Checker) ***\n");
		Trie trie = new Trie();
		String dictionary[] = { "abc$", "abcd$", "bce$", "abx$", "acfe$", "bfr$", "de$" };
		for (int i = 0; i < 7; i++)
			trie.insert(dictionary[i]);

		String document[] = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab" };
		int numWordsInDoc = 11;
		boolean spellCheck[] = new boolean[numWordsInDoc];

		for (int i = 0; i < numWordsInDoc; i++) {
			spellCheck[i] = trie.search(document[i] + "$");
		}

		System.out.println("Dictionary: " + Arrays.toString(dictionary));
		System.out.println("Document:   " + Arrays.toString(document));
		System.out.print("\nIncorrect spellings: ");
		for (int i = 0; i < numWordsInDoc; i++) {
			if (!spellCheck[i])
				System.out.print(document[i] + " ");
		}
	}

	public static void testHeapSort() throws Exception {
		System.out.println("\n*** Test Heap Sort ***\n");
		String[] array = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab", "abcd", "xy",
				"zxy", "abx", "def" };
		System.out.println("Before Sorting: " + Arrays.toString(array));
		HeapApplications.heapSort(array, array.length);
		System.out.println("After Sorting:  " + Arrays.toString(array));
	}

	private static void testTopKElements() throws Exception {

		System.out.println("*** Test Top-k ***\n");
		ArrayList<Student> students = Student.readStudents("src/PA6/students.txt");
		System.out.printf("Original Array:     %s%n", students);
		ArrayList<Student> top3 = HeapApplications.topK(students, 3);
		ArrayList<Student> top7 = HeapApplications.topK(students, 7);
		ArrayList<Student> all = HeapApplications.topK(students, students.size());
		System.out.print("Highest 3 students: " + top3);
		System.out.println();
		System.out.print("Highest 7 students: " + top7);
		System.out.println();
		System.out.printf("All students:       " + all);
	}

	public static void main(String[] args) throws Exception {

		testTrie();
		System.out.println();
		testHeapSort();
		System.out.println();
		testTopKElements();
	}
}
