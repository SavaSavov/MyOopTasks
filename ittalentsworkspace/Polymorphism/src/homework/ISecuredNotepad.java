package homework;

public interface ISecuredNotepad {

	boolean validatePass();
	
	boolean checkIfPassIsStrong(String pass);
}
