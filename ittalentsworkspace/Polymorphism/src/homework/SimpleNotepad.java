package homework;

import java.util.Arrays;

public class SimpleNotepad implements INotepad{
	
	private Page[] pages;
	
	public SimpleNotepad(Page[] pages) {
		if (pages != null) {
			this.pages = Arrays.copyOf(pages, pages.length);
		}
	}


	@Override
	public void addTextToDistinctPage(String text, int pageNumber) {
		if(validatePageNumber(pageNumber)){
			Page currPage  = this.getPages()[pageNumber - 1];
			
			currPage.addText(text);
		}
		
	}


	@Override
	public void deleteTextFromDistinctPageAndAddNewOne(String text, int pageNumber) {
		if(validatePageNumber(pageNumber)){
			Page currPage  = this.getPages()[pageNumber - 1];
			
			currPage.deletePageText();
			currPage.addText(text);
		}
		
	}


	@Override
	public void deleteTextFromDistinctPage(int pageNumber) {
		if(validatePageNumber(pageNumber)){
			Page currPage  = this.getPages()[pageNumber - 1];
			
			currPage.deletePageText();
		}
		
	}


	@Override
	public void showAllPages() {
		
		for (int index = 0; index < this.pages.length; index++) {
			Page currPage  = this.getPages()[index];
			System.out.println(currPage.showPageInfo());
		}
		
	}
	
	
	
	public boolean validatePageNumber(int pageNumber){
		
		if (pageNumber > 0 && pageNumber <= this.getPages().length) {
			return true;
		}else{
			System.out.println("Invalid page number!");
			return false;
		}
	}


	public Page[] getPages() {
		return pages;
	}


	@Override
	public boolean searchWord(String word) {
		boolean hasWord = false;
		if (word != null && (!word.equals(""))) {
			for (int index = 0; index < this.getPages().length; index++) {
				Page currPage = this.getPages()[index];
				if (currPage.searchWord(word)) {
					hasWord = true;
					System.out.print("The word you're searching is present on page " + (index + 1));
				}
			}
		}
		return hasWord;
	}


	@Override
	public void printAllPagesWithDigits() {
		
		for (int index = 0; index < this.getPages().length; index++) {
			Page currPage = this.getPages()[index];
			if (currPage.containsDigits()) {
				System.out.println(currPage.getHeader() + "\n" + currPage.getText());
			}
		}
		
		
	}
	
	

}
