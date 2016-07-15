package homework1.computertask;

public class Computer {

	int year;
	double price;
	boolean isNotebook;
	double hardDiskMemory;
	double freeMemory;
	String operationSystem;
	
	Computer() {
		isNotebook = false;
		operationSystem = "Win XP";
	}
	
	Computer(int year, double price, double hardDiskMemory, double freeMemory){
		this();
		
		if(year <= 2016 && year > 1980){
			this.year = year;
		}
		
		if(price > 0.0){
			this.price = price;
		}
		
		if(hardDiskMemory > 0.0){
			this.hardDiskMemory = hardDiskMemory;
		}
		
		if(freeMemory > 0.0 && freeMemory <= hardDiskMemory){
			this.freeMemory = freeMemory;
		}
		
	}
	
	Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory, String operationSystem){
		
		if(year < 2016 && year > 1980){
			this.year = year;
		}
		
		if(price > 0.0){
			this.price = price;
		}
		
		this.isNotebook = isNotebook;
		
		if(hardDiskMemory > 0.0){
			this.hardDiskMemory = hardDiskMemory;
		}
		
		if(freeMemory > 0.0 && freeMemory <= hardDiskMemory){
			this.freeMemory = freeMemory;
		}
		
		if(operationSystem != null && !operationSystem.equals("")){
			this.operationSystem = operationSystem;
		}
	}
	
	int comparePrice(Computer computer) {

		int comparePrice = 2;
		
		if (computer != null) {
			if (this.price > computer.price) {
				comparePrice = -1;
			} else {
				if (this.price == computer.price) {
					comparePrice = 0;
				} else {
					comparePrice = 1;
				}
			}
		} else {
			System.out.println("The computer that you're trying to compare doesn't exist!!!");
		}
		
		return comparePrice;
		
	}
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nComputer's year of manifacture is: " + year);
		sb.append("\nit's price is: " + price);
		sb.append("\ncomputer is notebook: " + isNotebook);
		sb.append("\nhard disk memory of the computer is: " + hardDiskMemory + " GB");
		sb.append("\ncomputer has: " + freeMemory + " GB free memory");
		sb.append("\nand it's operating system is: " + operationSystem + "\n");
		
		return sb.toString();
	}
}
