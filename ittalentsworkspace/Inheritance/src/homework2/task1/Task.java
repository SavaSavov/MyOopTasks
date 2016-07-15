package homework2.task1;

public class Task {
	
	private String taskName;
	private double workingHours;

	
	public Task(String taskName, double workingHours) {
		setTaskName(taskName);
		setWorkingHours(workingHours);
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		if (taskName != null && (!taskName.equals(""))) {
			this.taskName = taskName;
		}else{
			System.out.println("Invalid task name!");
		}
	}
	
	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		if (workingHours >= 0.0) {
			this.workingHours = workingHours;
		} else {
			System.out.println("Enter valid working hours!");
		}
	}
	
	

}
