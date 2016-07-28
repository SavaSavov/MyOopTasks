package homework;

import exeptions.WeakPasswordException;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {
	
	private boolean isNotepadStarted = false;

	public ElectronicSecuredNotepad(Page[] pages, String password) throws WeakPasswordException {
		super(pages, password);
	}

	@Override
	public void start() {
		this.isNotepadStarted = true;
	}

	@Override
	public void stop() {
		this.isNotepadStarted = false;
	}

	@Override
	public boolean isStarted() {	
		return this.isNotepadStarted;
	}
	
	@Override
	public void addTextToDistinctPage(String text, int pageNumber) {

		if (isStarted()) {
				super.addTextToDistinctPage(text, pageNumber);	
		}else{
			System.out.println("The notepad is not started. If you want to continue you have to start the notepad!");
		}
				
	}


	@Override
	public void deleteTextFromDistinctPageAndAddNewOne(String text, int pageNumber) {

		if (isStarted()) {
				super.deleteTextFromDistinctPageAndAddNewOne(text, pageNumber);
		}else{
			System.out.println("The notepad is not started. If you want to continue you have to start the notepad!");
		}

	}


	@Override
	public void deleteTextFromDistinctPage(int pageNumber) {

		if (isStarted()) {

				super.deleteTextFromDistinctPage(pageNumber);
		}else{
			System.out.println("The notepad is not started. If you want to continue you have to start the notepad!");
		}

	}


	@Override
	public void showAllPages() {

		if (isStarted()) {
			for (int index = 0; index < super.getPages().length; index++) {
				System.out.println(super.getPages()[index].showPageInfo());
			}

		}else{
			System.out.println("The notepad is not started. If you want to continue you have to start the notepad!");
		}

	}
	
	@Override
	public boolean searchWord(String word){
		if (isStarted()) {
			return super.searchWord(word);
		}else{
			System.out.println("The notepad is not started. If you want to continue you have to start the notepad!");
		}
		
		return false;
	}
	
	@Override
	public void printAllPagesWithDigits() {
		if (isStarted()) {
			super.printAllPagesWithDigits();
		}else{
			System.out.println("The notepad is not started. If you want to continue you have to start the notepad!");
		}
	}

}
