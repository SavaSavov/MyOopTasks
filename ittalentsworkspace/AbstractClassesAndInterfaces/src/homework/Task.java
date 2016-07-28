package homework;

public class Task {
	
	private String taskName;
	private int workingHours;

	
	public Task(String taskName, int workingHours) {
		setTaskName(taskName);
		setWorkingHours(workingHours);
	}

	
	//	setters and getters
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
	
	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		if (workingHours >= 0) {
			this.workingHours = workingHours;
		} else {
			System.out.println("Enter valid working hours!");
		}
	}
	
	

}
