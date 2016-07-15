package homework1.collegetask;

public class StudentGroup {
	
	String groupSubject;
	Student[] students;
	int freePlaces;
	
	StudentGroup() {
		
		students = new Student[5];
		freePlaces = 5;
		
	}
	
	StudentGroup(String subject) {
		
		this();
		
		if(subject != null && (!subject.equals(""))){
			this.groupSubject = subject;
		}else{
			System.out.println("Subject field can't be empty!!!");
		}
	}
	
	void addStudent(Student newStudent){
		
		if(newStudent != null){
			if(newStudent.subject.equals(this.groupSubject)){
				if(this.freePlaces > 0){
					int index = (-1)*(freePlaces - 5);
					students[index] = newStudent;
					System.out.println("Student successfully added!");
					freePlaces--;
				}else{
					System.out.println("\nThe group in which you're trying to add student is full!\n"
							+ "Try to add student in different group.");
				}
			}else{
				System.out.println("\nThe subject of the student that \n"
						+ "you're trying to add is different from group subject!!!");
			}
		}else{
			System.out.println("\nYou're trying to add invalid student!!!");
		}
		
	}
	
	void emptyGroup(){
		students = null;
		students = new Student[5];
		freePlaces = 5;
	}
	
	String theBestStudent() {

		String bestStudentName = "";
		double bestGrade = 2;

		if (students != null) {

			for (int index = 0; index < students.length; index++) {
				Student currStudent = students[index];

				if (currStudent != null) {
					if (currStudent.grade > bestGrade) {
						bestGrade = currStudent.grade;
						bestStudentName = currStudent.name;
					}
				} else {
					System.out.println("\nPlease add students into group!");
					break;
				}
			}
		}else{
			System.out.println("The group is empty.");
		}

		return bestStudentName;
	}
	
	void printStudentsInGroup() {

		StringBuilder sb = new StringBuilder();

		if (students != null) {

			int count = 0;

			for (int index = 0; index < students.length; index++) {

				Student currStudent = students[index];

				if (currStudent != null) {
					sb.append("\nName of the student is: " + currStudent.name);
					sb.append("\nand he/she studies: " + currStudent.subject);
					sb.append("\ngrade for the subject: " + currStudent.grade);
					sb.append("\nhe/she is: " + currStudent.yearInCollege + " year in college");
					sb.append("\nhe/she is: " + currStudent.age + " years old");
					if (currStudent.yearInCollege == 4) {
						sb.append("\nthe student graduates this year ");
					} else {
						sb.append("\nthe student has " + (4 - currStudent.yearInCollege) + " more years in college");
					}
					sb.append("\nstudent has " + currStudent.money + " from scholarships available.\n");
				} else {
					count++;
					if (count == 1) {
						sb.append("\nThe group isn't filled yet. There are " + this.freePlaces
								+ " more places in the group!");
					}
				}
			}

		} else {
			sb.append("The group that you're trying to display is empty!");
		}

		System.out.println(sb.toString());
	}

}
