package PA6;

import java.util.ArrayList;

public class HeapApplications {

	public static void heapSort(String array[], int arrayLen) throws Exception { // complete this function
		GenericHeap<String> stringHeap = new GenericHeap<String>(new StringComparator());
//		Felt like using an enhanced for-loop since I haven't in a while
		for(String x: array) {
			stringHeap.insert(x);
		}
//		for(int i = 0; i < arrayLen; i++) {
//			stringHeap.insert(array[i]);
//		}
		for(int i = 0; i < arrayLen; i++) {
			array[i] = stringHeap.top();
			stringHeap.extract();
		}
	}

	public static ArrayList<Student> topK(ArrayList<Student> students, int k) { // complete this function
		if(k > students.size()) {
			k = students.size();
		}
		GenericHeap<Student> studentHeap = new GenericHeap<Student>(new StudentComparator());
		StudentComparator compareStudent = new StudentComparator();
		for(int i = 0; i < k; i++) {
			studentHeap.insert(students.get(i));
		}
		for(int i = k; i < students.size(); i++) {
			Student min = studentHeap.top();
			Student current = students.get(i);
			if(compareStudent.compare(min, current) < 0) {
				studentHeap.extract();
				studentHeap.insert(current);
			}
		}
		ArrayList<Student> topStudents = new ArrayList<Student>();
		for(int i = 0; i < k; i++) {
			topStudents.add(studentHeap.top());
			studentHeap.extract();
		}
		return topStudents;
	}
}
