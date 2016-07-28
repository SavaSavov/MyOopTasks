package homework;

public class EmployeeTest {

	public static void main(String[] args) {
	

		Task task1 = new Task("Create application", 8);		
		Task task2 = new Task("Debug application", 8);
		Task task3 = new Task("Count application", 14);
		Task task4 = new Task("Homework application", 16);		
		Task task5 = new Task("Classwork application", 4);
		Task task6 = new Task("Gas station application", 24);
		Task task7 = new Task("Fantastico application", 16);		
		Task task8 = new Task("Hospital application", 36);
		Task task9 = new Task("Online shop application", 15);
		Task task10 = new Task("Java application", 28);		
		
		AllWork work = new AllWork();
		
		work.addTask(task1);
		work.addTask(task2);
		work.addTask(task3);
		work.addTask(task4);
		work.addTask(task5);
		work.addTask(task6);
		work.addTask(task7);
		work.addTask(task8);
		work.addTask(task9);
		work.addTask(task10);
		
		Employee.setAllwork(work);
		
		Employee mara = new Employee("Maria Smokova");
		Employee ceci = new Employee("Ceci Nikolova");
		Employee ganka = new Employee("Ganka Ganeva");

		
		int count = 0;
		
		while(true){
				System.out.println("\nEmployees are starting their " + (count + 1) + " day at work.");
				mara.startWorkingDay();
				ceci.startWorkingDay();
				ganka.startWorkingDay();
				
				mara.work();
				ceci.work();
				ganka.work();

				count++;

				
				if((Employee.getAllwork().isAllWorkDone())){
					break;
				}
				

		}
		
		System.out.println("Employees have finished all work for " + count + " days.");

	}

}
