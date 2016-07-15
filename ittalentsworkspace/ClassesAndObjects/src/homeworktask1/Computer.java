package homeworktask1;

public class Computer {

	int year;
	double price;
	boolean isNotebook;
	double hardDiskMemory;
	double freeMemory;
	String operationSystem;
	
	void changeOperationSystem(String newOperationSystem){
		if((newOperationSystem != null) && (!newOperationSystem.equals(""))){
			operationSystem = newOperationSystem;
		}
	}
	
	void useMemory(double memory){
		if(memory > 0.0 && memory <= freeMemory){
			freeMemory -= memory;
		}else{
			System.out.println( "\nNot enough free memory!");
		}
	}
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nComputer year of manifacture is: " + year);
		sb.append("\nprice is: " + price);
		sb.append("\ncomputer is notebook: " + isNotebook);
		sb.append("\nhard disk memory of the computer is: " + hardDiskMemory + " GB");
		sb.append("\ncomputer has: " + freeMemory + " GB free memory");
		sb.append("\nand it's operating system is: " + operationSystem);
		
		return sb.toString();
	}
}
