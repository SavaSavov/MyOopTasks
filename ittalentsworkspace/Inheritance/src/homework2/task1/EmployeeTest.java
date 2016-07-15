package homework2.task1;

public class EmployeeTest {

	public static void main(String[] args) {
	

		Task task1 = new Task("Create application", 16.0);
		Employee sava = new Employee("Sava Savov");
		
		sava.setHoursLeft(8);
		sava.setCurrentTask(task1);
		
		sava.work();
		
		sava.showReport();
		
		Task task2 = new Task("Debug application", 6.0);
		Employee ceci = new Employee("Ceci Nikolova");
		
		ceci.setHoursLeft(8);
		ceci.setCurrentTask(task2);
		
		ceci.work();
		
		ceci.showReport();

	}

}
