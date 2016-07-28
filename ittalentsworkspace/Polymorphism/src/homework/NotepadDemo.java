package homework;

import java.util.Scanner;

import exeptions.WeakPasswordException;

public class NotepadDemo {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Page page1 = new Page("Homework", "This is homework page.");
		Page page2 = new Page("Classwork", "This is classwork page.");
		Page page3 = new Page("Text page", "The text here is really strange");
		Page page4 = new Page("Jumaqta", "Jumaqta is very cute place");
		Page page5 = new Page("Machine", "Savata is machine");
		Page page6 = new Page("Debug page", "I had to debug this task many times before I've succeeded");
		
		Page[] myPages = {page1, page2, page3, page4, page5, page6};
		
		INotepad myNotepad = null;
		String password = "";


			try {
				System.out.println("Enter password for your secured notepad:");
				password = input.next();
				myNotepad = new SecuredNotepad(myPages, password);
			} catch (WeakPasswordException exc) {
				System.out.println("The entered password is weak. It has to be at least 5 symbols, one capital character"
								+ "\none small character and one digit!");

			}
			
			
			if (myNotepad != null) {
				myNotepad.showAllPages();

				myNotepad.addTextToDistinctPage(" and it was hard implementing it", 1);

				myNotepad.showAllPages();

				myNotepad.deleteTextFromDistinctPageAndAddNewOne("Ama samo na dumi", 6);

				myNotepad.showAllPages();
			}
		
		input.close();

	}

}
