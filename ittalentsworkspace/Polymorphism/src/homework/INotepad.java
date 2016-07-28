package homework;

public interface INotepad {

	void addTextToDistinctPage(String text, int pageNumber);
	
	void deleteTextFromDistinctPageAndAddNewOne(String text, int pageNumber);
	
	void deleteTextFromDistinctPage(int pageNumber);
	
	void showAllPages();
	
	boolean searchWord(String word);
	
	void printAllPagesWithDigits();
}
