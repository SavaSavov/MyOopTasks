package homework;

public class AllWork {
	
	public static final int INITIAL_NUMBER_OF_UNASSIGNED_TASKS = 10;
	private static final int START_INDEX_FOR_UNASSIGNED_TASKS = 0;
	
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	
	public AllWork() {
		setTasks(new Task[INITIAL_NUMBER_OF_UNASSIGNED_TASKS]);
		setFreePlacesForTasks(INITIAL_NUMBER_OF_UNASSIGNED_TASKS);
		setCurrentUnassignedTask(START_INDEX_FOR_UNASSIGNED_TASKS);
	}
	
	public void addTask(Task taskForAssigning) {
		if (taskForAssigning != null) {
			int currFreePlaces = getFreePlacesForTasks();
			int currIndex = currFreePlaces - INITIAL_NUMBER_OF_UNASSIGNED_TASKS;
			int absIndex = (currIndex < 0) ? (-1) * currIndex : currIndex;

			if (currFreePlaces > 0) {
				getTasks()[absIndex] = taskForAssigning;
				setFreePlacesForTasks(--currFreePlaces);
			} else {
				System.out.println("There isn't place for more tasks.");
			}
		} else {
			System.out.println("You're trying to assign invalid task!");
		}
	}
	
	public Task getNextTask() {

		int currUnassignedIndex = getCurrentUnassignedTask();
		int currFreePlaces = getFreePlacesForTasks();
		Task nextTask = getTasks()[currUnassignedIndex];

		if (nextTask != null) {
			setCurrentUnassignedTask(++currUnassignedIndex);
			setFreePlacesForTasks(++currFreePlaces);
			return nextTask;
		}
		
		return nextTask;

	}
	
	public boolean isAllWorkDone(){
		boolean isDone = true;
		for(Task currTask : this.getTasks()){
			if(currTask != null && currTask.getWorkingHours() != 0){
				isDone = false;
				break;
			}
		}
		
		return isDone;
		
	}
	
	
	//	setters and getters
	public Task[] getTasks() {
		return tasks;
	}

	public void setTasks(Task[] tasks) {
		if (tasks != null) {
			this.tasks = tasks;
		}
	}

	public int getFreePlacesForTasks() {
		return freePlacesForTasks;
	}

	public void setFreePlacesForTasks(int freePlacesForTasks) {
		if (freePlacesForTasks >= 0) {
			this.freePlacesForTasks = freePlacesForTasks;
		}else{
			System.out.println("You're trying to input invalid number for number of free places!");
		}
	}

	public int getCurrentUnassignedTask() {
		return currentUnassignedTask;
	}

	public void setCurrentUnassignedTask(int currentUnassignedTask) {
		if (currentUnassignedTask >= 0 && currentUnassignedTask <= INITIAL_NUMBER_OF_UNASSIGNED_TASKS) {
			this.currentUnassignedTask = currentUnassignedTask;
		}
	}
	
	
}
