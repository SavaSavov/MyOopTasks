package homework;

public class Page {
	
	private static final int MISSING_WORD_NUMBER = -1;
	private String header;
	private String text;
	
	public Page(String header){
		setHeader(header);
	}
	
	public Page(String header, String text){
		this(header);
		setText(text);
	}
	
	public void addText(String text) {

		StringBuilder sb = new StringBuilder();

		if (text != null && (!text.equals(""))) {
			if (this.getText() != null && (!this.getText().equals(""))) {
				sb.append(this.getText() + text);
			} else {
				sb.append("\n" + text);
			}

			this.setText(sb.toString());
		} else {
			System.out.println("Enter some text.");
		}

	}
	
	public void deletePageText(){

		this.setText("");
		
	}
	
	public String showPageInfo(){
		
		StringBuilder sb = new StringBuilder();
		
		if (this.getText() != null && (!this.getText().equals(""))) {
			sb.append("\n" + this.getHeader() + "\n" + this.getText());
		} else {
			sb.append("\n" + this.getHeader() + "\n" + "The requested page is empty. You could add some text to it.");
		}
			
		return sb.toString();
	}
	
	public boolean searchWord(String word){
		
		if(word != null && (!word.equals(""))){
			int index = this.getText().indexOf(word);
			if(index != MISSING_WORD_NUMBER){
				System.out.println("The word that you've entered is on " + index + " position.");
				return true;
			}else{
				System.out.println("The word that you've entered is missing from the text.");
				return false;
			}
		}else{
			System.out.println("You've entered empty string.");
			return false;
		}
	}
	
	public boolean containsDigits() {
		String text = this.getText();
		boolean hasDigits = false;

		for (int index = 0; index < text.length(); index++) {
			if (text.charAt(index) >= '0' && text.charAt(index) <= '9') {
				hasDigits = true;
				break;
			}
		}

		return hasDigits;

	}
	
//	getters and setters
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		if (header != null && (!header.equals(""))) {
			this.header = header;
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if (text != null) {
			this.text = text;
		}
	}

}
