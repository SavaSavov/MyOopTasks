package homework1.computertask;

public class ComputerTest {

	public static void main(String[] args) {
		

		Computer pc = new Computer(2016, 899.00, 800, 500);
		Computer noteBook = new Computer(2015, 699.00, true, 300, 100, "Mac");
		
		System.out.println("First computer data is:");
		System.out.println(pc.toString());
		
		System.out.println("Second computer data is:");
		System.out.println(noteBook.toString());
		
		int result = pc.comparePrice(noteBook);
		
		if (result != 2) {
			if (result == -1) {
				System.out.println("Price of the PC computer is bigger than the price of the Notebook one.");
			} else {
				if (result == 0) {
					System.out.println("Both computers have the same price.");
				} else {
					System.out.println("Price of the Notebook computer is bigger than the price of the PC one.");
				}
			}
		}

	}

}
