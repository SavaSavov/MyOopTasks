package homework1.collegetask;

public class CollegeTest {

	public static void main(String[] args) {
	

		Student student1 = new Student("Sava", "physics", 25);
		Student student2 = new Student("Cecka", "math", 30);
		Student student3 = new Student("George", "math", 25);
		Student student4 = new Student("Kalina", "math", 25);
		Student student5 = new Student("Gerga", "math", 24);
		Student student6 = new Student("Ganka", "math", 25);
		
		student2.grade = 5.0;
		student2.receiveScholarship(4.50, 100);
		student3.receiveScholarship(4.50, 100);
		student4.grade = 5.50;
		student4.receiveScholarship(4.50, 150);
		student6.yearInCollege = 4;
		student5.upYear();
		
		StudentGroup firstGroup = new StudentGroup("math");
		
		String bestStudentName = firstGroup.theBestStudent();

		if (bestStudentName != null && (!bestStudentName.equals(""))) {
			System.out.println("The name of the student with the highest grade in this group is: " + bestStudentName);
		}
		
		firstGroup.addStudent(student1);
		firstGroup.addStudent(student2);
		firstGroup.addStudent(student3);
		firstGroup.addStudent(student4);
		firstGroup.addStudent(student5);
		firstGroup.addStudent(student6);

		
		firstGroup.printStudentsInGroup();
		
		firstGroup.emptyGroup();
		
		firstGroup.printStudentsInGroup();

	}

}
