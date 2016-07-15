package homework2.task1;

public class Employee {
	
	private String employeeName;
	private Task currentTask;
	private double hoursLeft;
	
	
	public Employee(String employeeName) {
		setEmployeeName(employeeName);
	}
	

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
		if (currentTask != null) {
			this.currentTask = currentTask;
		}else{
			System.out.println("No task assigned!");
		}
	}
	
	public double getHoursLeft() {
		return hoursLeft;
	}
	
	public void setHoursLeft(double hoursLeft) {
		if (hoursLeft >= 0.0) {
			this.hoursLeft = hoursLeft;
		}else{
			System.out.println("Invalid input!");
		}
	}
	
	public void work(){
		if(this.getCurrentTask().getWorkingHours() > this.getHoursLeft()){
			this.getCurrentTask().setWorkingHours(this.getCurrentTask().getWorkingHours() - this.getHoursLeft());
			this.setHoursLeft(0);
		}else{
			if(this.getCurrentTask().getWorkingHours() == this.getHoursLeft()){
				this.setHoursLeft(0);
				this.getCurrentTask().setWorkingHours(0);
			}else{
				this.setHoursLeft(this.getHoursLeft() - this.getCurrentTask().getWorkingHours());
				this.getCurrentTask().setWorkingHours(0);
			}
		}
	}
	
	public void showReport() {

		StringBuilder sb = new StringBuilder();

		sb.append("\nName of the employee is: " + this.getEmployeeName());
		sb.append("\nname of the assigned task to the employee is: \" " + this.getCurrentTask().getTaskName() + " \"");
		
		if (this.getHoursLeft() == 0.0) {
			sb.append("\nemployee has finished work for the day");
		} else {
			sb.append("\nemployee has " + this.getHoursLeft() + " more hours at work");
		}
		
		if(this.getCurrentTask().getWorkingHours() == 0.0){			
			sb.append("\nthe time for fulfilling assigned task has finished.");
		}else{			
			sb.append("\nand has " + this.getCurrentTask().getWorkingHours()
					+ " more hours to fulfil the assigned task.");
		}


		System.out.println(sb.toString());

	}

}
