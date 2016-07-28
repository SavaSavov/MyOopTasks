package homework;

import java.util.Scanner;

import exeptions.WeakPasswordException;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad{
	private static final int MINIMUM_NUMBERS_FOR_STRONG_PASS = 5;
	private static Scanner input;
	private String password;
	
	static{
		input = new Scanner(System.in);
	}
	
	public SecuredNotepad(Page[] pages, String password) throws WeakPasswordException {
		super(pages);

		if (this.checkIfPassIsStrong(password)) {
			this.setPassword(password);
		} else {
			throw new WeakPasswordException();
		}
	}
	
	@Override
	public void addTextToDistinctPage(String text, int pageNumber) {

		if (validatePass()) {
				super.addTextToDistinctPage(text, pageNumber);	
		}
				
	}


	@Override
	public void deleteTextFromDistinctPageAndAddNewOne(String text, int pageNumber) {

		if (validatePass()) {
				super.deleteTextFromDistinctPageAndAddNewOne(text, pageNumber);
		}

	}


	@Override
	public void deleteTextFromDistinctPage(int pageNumber) {

		if (validatePass()) {

				super.deleteTextFromDistinctPage(pageNumber);
		}

	}


	@Override
	public void showAllPages() {

		if (validatePass()) {
			for (int index = 0; index < super.getPages().length; index++) {
				System.out.println(super.getPages()[index].showPageInfo());
			}

		}

	}
	
	@Override
	public boolean validatePass() {
		System.out.println("This is a secured notebook. If you want to continue you have to enter your password:");
		String enteredPass = input.next();
		
		if(enteredPass.equals(this.getPassword())){
			return true;
		} else {
			System.out.println("You've entered invalid password! You can't perform the operation.");
			return false;
		}
	}
	
	@Override
	public boolean searchWord(String word){
		if (validatePass()) {
			return super.searchWord(word);
		}
		
		return false;
	}
	
	@Override
	public void printAllPagesWithDigits() {
		if (validatePass()) {
			super.printAllPagesWithDigits();
		}
	}

	@Override
	public boolean checkIfPassIsStrong(String pass) {
		boolean isPassStrong = false;
		
		if(pass != null && (!pass.equals(""))){
			for (int index = 0; index < pass.length(); index++) {
				if(pass.length() >= MINIMUM_NUMBERS_FOR_STRONG_PASS){
					if((this.checkifPassContainsCapitalLetter(pass) && this.checkifPassContainsSmallLetter(pass)
							&& this.checkifPassContainsDigits(pass))){
						isPassStrong = true;
						break;
					}
				}
			}
		}
		return isPassStrong;
	}
	
	public boolean checkifPassContainsCapitalLetter(String pass) {
		boolean containsCapitals = false;
		for (int index = 0; index < pass.length(); index++) {
			if ((pass.charAt(index) >= 'A' && pass.charAt(index) <= 'Z')) {
				containsCapitals = true;
				break;
			}
		}

		return containsCapitals;

	}
	
	public boolean checkifPassContainsSmallLetter(String pass) {
		boolean containsSmallLetters = false;
		for (int index = 0; index < pass.length(); index++) {
			if ((pass.charAt(index) >= 'a' && pass.charAt(index) <= 'z')) {
				containsSmallLetters = true;
				break;
			}
		}

		return containsSmallLetters;

	}
	
	public boolean checkifPassContainsDigits(String pass) {
		boolean containsDigits = false;
		for (int index = 0; index < pass.length(); index++) {
			if ((pass.charAt(index) >= '0' && pass.charAt(index) <= '9')) {
				containsDigits = true;
				break;
			}
		}

		return containsDigits;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password != null && (!password.equals(""))) {
			this.password = password;
		}
	}	
	
}
