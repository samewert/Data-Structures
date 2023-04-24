package PA6;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class GenericSelectionSort<T> { // A generic class for selection sorting comparable objects

	Comparator<T> comparator; // This is used to compare the objects of the class

	GenericSelectionSort(Comparator<T> comparator) { // Constructor will set the comparator for the specific class
		this.comparator = comparator;
	}

	public void sort(ArrayList<T> content) {
		for (int i = 0; i < content.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < content.size(); j++) {
				T minValue = content.get(minIndex); // get the reference to the object at minIndex
				T currentValue = content.get(j); // get the reference to the object at j
				if (comparator.compare(currentValue, minValue) < 0) { // this checks if the item at index j is smaller than the one at minIndex
					// < 0 implies currentValue is smaller than minValue
					// = 0 means they are the same
					// > 0 means currentValue is larger than minValue
					minIndex = j;
				}
			}
			// swap contents
			T temp = content.get(minIndex);
			content.set(minIndex, content.get(i));
			content.set(i, temp);
		}
	}

	static final String STUDENT_PATH = "src/PA6/students.txt";

	private static void stringSort() {
		System.out.println("*** String Selection Sort ***\n");
		String arr[] = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab", "abcd", "xy",
				"zxy", "abx", "def" };
		ArrayList<String> strings = new ArrayList<String>();
		for (String str : arr)
			strings.add(str);

		// Create selection sort instance for sorting strings; use the comparator
		// StringComparator
		GenericSelectionSort<String> stringSelectionSort = new GenericSelectionSort<String>(new StringComparator());

		System.out.print("Original Order: ");
		for (String str : strings)
			System.out.print(str + " ");
		stringSelectionSort.sort(strings);
		System.out.print("\nAfter Sorting:  ");
		for (String str : strings)
			System.out.print(str + " ");
		System.out.println("\n");
	}

	private static void studentSort() throws FileNotFoundException {
		System.out.println("*** Student Selection Sort ***\n");
		ArrayList<Student> students = Student.readStudents(STUDENT_PATH);
		System.out.print("Original Order: ");
		for (Student student : students)
			System.out.print(student.toString() + " ");

		// Create selection sort instance for sorting Students; use the comparator
		// StudentComparator
		GenericSelectionSort<Student> studentSelectionSort = new GenericSelectionSort<Student>(new StudentComparator());

		studentSelectionSort.sort(students);
		System.out.print("\nAfter Sorting:  ");
		for (Student student : students)
			System.out.print(student.toString() + " ");
	}

	public static void main(String[] args) throws FileNotFoundException {
		stringSort();
		studentSort();
	}
}
