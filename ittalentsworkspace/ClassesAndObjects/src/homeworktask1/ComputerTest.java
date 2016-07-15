package homeworktask1;

public class ComputerTest {

	public static void main(String[] args) {
		

		Computer pc = new Computer();
		Computer noteBook = new Computer();
		
		
		
		pc.year = 2016;
		pc.price = 899.00;
		pc.isNotebook = false;
		pc.hardDiskMemory = 500.0;
		pc.freeMemory = 250.0;
		pc.operationSystem = "Windows 10 Pro";
		
		noteBook.year = 2016;
		noteBook.price = 699.00;
		noteBook.isNotebook = true;
		noteBook.hardDiskMemory = 250.0;
		noteBook.freeMemory = 90.0;
		noteBook.operationSystem = "Linux Mint Rosa";
		
		System.out.println("First computers have these parameters:");
		System.out.println(pc.toString());
		System.out.println(noteBook.toString());
		
		System.out.println("\nAsking for extra 100 GB from 90 GB available memory,\n"
				+ " in the notebook computer ends:");
		
		noteBook.useMemory(100);
		
		System.out.println("\nAnd now it's parameters look like this: ");
		
		System.out.println(noteBook.toString());
		
		System.out.println("\nAfter realizing that the best operation system in the world is Linux,\n"
				+ "we are changing the one in the first pc, and now it's parameters look like this: ");
		
		pc.changeOperationSystem("Linux Mint Rosa");
		
		System.out.println(pc.toString());

	}

}
