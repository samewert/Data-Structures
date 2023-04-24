package PA6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

	public String name;
	public int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String toString() {
		return String.format("(%s, %d)", name, grade);
	}

	public static ArrayList<Student> readStudents(String filePath) throws FileNotFoundException { // complete this method
		ArrayList<Student> students = new ArrayList<Student>();
		Scanner scan = new Scanner(new FileReader(filePath));
		while(scan.hasNext()) {
			students.add(new Student(scan.next(), scan.nextInt()));
		}
		return students;
	}
}
