package homework;

public class Employee {
	
	private static final int WORKING_DAY_HOURS = 8;
	
	private String employeeName;
	private Task currentTask;
	private int hoursLeft;
	private static AllWork allwork;
	
	static {
		setAllwork(new AllWork());
	}	
	
	public Employee(String employeeName) {
		setEmployeeName(employeeName);
	}
	
	
	public void work() {

		Task nextTask = null;
		Task currTask = this.getCurrentTask();
		int currEmployeeHoursLeft = this.getHoursLeft();

		if (currTask == null && Employee.getAllwork().getCurrentUnassignedTask() < AllWork.INITIAL_NUMBER_OF_UNASSIGNED_TASKS) {
			nextTask = Employee.getAllwork().getNextTask();
			if (nextTask != null) {
				this.setCurrentTask(nextTask);
				currTask = this.getCurrentTask();

			}
		}
		
		if(currTask == null){
				System.out.println("\nThere aren't unassigned tasks! Employee " + this.getEmployeeName() + " has finished her tasks and is having break.");
		}
		
		if (currTask != null) {
			System.out.println("\nEmployee " + this.getEmployeeName() + " works on " + currTask.getTaskName() + " task");
			if (currTask.getWorkingHours() > currEmployeeHoursLeft) {
				currTask.setWorkingHours(currTask.getWorkingHours() - currEmployeeHoursLeft);
				this.setHoursLeft(0);
				this.showReport();
			} else {
				if (currTask.getWorkingHours() == currEmployeeHoursLeft) {
					this.setHoursLeft(0);
					currTask.setWorkingHours(0);
					this.showReport();
					this.setCurrentTask(null);

				} else {
					this.setHoursLeft(currEmployeeHoursLeft - this.getCurrentTask().getWorkingHours());
					currTask.setWorkingHours(0);
					this.showReport();
					this.setCurrentTask(null);
					if (Employee.getAllwork().getCurrentUnassignedTask() < AllWork.INITIAL_NUMBER_OF_UNASSIGNED_TASKS) {
						this.work();
					}

				}
			}
		}


	}
	
	public void showReport() {

		StringBuilder sb = new StringBuilder();

		if (this.getHoursLeft() != 0 && Employee.getAllwork().getCurrentUnassignedTask() != AllWork.INITIAL_NUMBER_OF_UNASSIGNED_TASKS) {
			sb.append("employee has " + this.getHoursLeft() + " more hours at work and she's taking new task.\" "
					+ this.getCurrentTask().getTaskName() + " \" to work till the end of the work day.");
		} else {
			if(this.getHoursLeft() != 0 && this.getCurrentTask().getWorkingHours() == 0){
			sb.append("employee has " + this.getHoursLeft() + " more hours at work but tasks have finished and is time for break.");
			}
		}

		if (this.getCurrentTask().getWorkingHours() == 0 && this.getHoursLeft() == 0) {
			sb.append("has completed taken \"" + this.getCurrentTask().getTaskName()
					+ " \" task during this work day, and has finished work.");
		} else {
			if (this.getHoursLeft() == 0) {
				sb.append("and has " + (this.getCurrentTask().getWorkingHours() - this.getHoursLeft())
						+ " more hours to work at the \"" + this.getCurrentTask().getTaskName()
						+ "\" task during next work day.");
			}
		}


		System.out.println(sb.toString());

	}
	
	public void startWorkingDay(){
		this.setHoursLeft(WORKING_DAY_HOURS);
	}
	
	//	setters and getters
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		if (employeeName != null && (!employeeName.equals(""))) {
			this.employeeName = employeeName;
		}else{
			System.out.println("You have to enter name for the employee!");
		}
	}
	
	public Task getCurrentTask() {
		return currentTask;
	}
	
	public void setCurrentTask(Task currentTask) {
			this.currentTask = currentTask;
	}
	
	public int getHoursLeft() {
		return hoursLeft;
	}
	
	public void setHoursLeft(int hoursLeft) {
		if (hoursLeft >= 0) {
			this.hoursLeft = hoursLeft;
		}else{
			System.out.println("Invalid input!");
		}
	}

	public static AllWork getAllwork() {
		return allwork;
	}

	public static void setAllwork(AllWork allwork) {
		if (allwork != null) {
			Employee.allwork = allwork;
		}
	}
	
}
