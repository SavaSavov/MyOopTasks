package homework1.collegetask;

public class Student {
	
	String name;
	String subject;
	double grade;
	int yearInCollege;
	int age;
	boolean isDegree;
	double money;
	
	Student() {
		
		grade = 4;
		yearInCollege = 1;
		isDegree = false;
		money = 0.0;
		
	}

	Student(String name, String subject, int age) {
		
		this();

		if (name != null && (!name.equals(""))) {
			this.name = name;
		} else {
			System.out.println("Name of the student can't be empty.");
		}

		if (subject != null && (!subject.equals(""))) {
			this.subject = subject;
		} else {
			System.out.println("You have to fill subject field.");
		}

		if (age > 18 && age < 50) {
			this.age = age;
		} else {
			System.out.println("Invalid age!!!");
		}
	}
	
	void upYear() {

		if (!isDegree) {
			yearInCollege++;
			if (yearInCollege == 4) {
				isDegree = true;
			}
		} else {
			System.out.println("The student has graduated already!!!");
		}
	}
	
	double receiveScholarship(double min, double amount) {

		if (min >= 2 && min <= 6 && amount > 0.0) {
			if (this.grade >= min) {
				if (this.age < 30) {
					this.money += amount;
					System.out.println("Successfully added " + amount + " to student " + this.name + " account.");
				} else {
					System.out.println(
							"The student " + this.name + " age is over the maximum allowed for receiving scholarship!");
				}
			} else {
				System.out.println(
						"The student " + this.name + " grade is under the minimum grade for receiving scholarship!");
			}
		}else{
			System.out.println("You're trying to give invalid data ");
		}

		return this.money;
	}

}
