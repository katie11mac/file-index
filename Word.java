// I have neither given nor received unauthorized aid on this assignment. 

import java.util.ArrayList;

public class Word implements Comparable<Word>{

	private String text; // actual word (key) 
	private ArrayList<String> fileList = new ArrayList<String>(); // List of all files containing this word 
	
	
	//--CONSTRUCTORS---
	
	// Empty constructor: called to make an object of type Word 
	public Word() {
		
	}
	
	// Non-empty constructor: called to make an object of type Word with its text filled 
	public Word(String w) {
		this.text = w; 
	}
	
	//------SETTERS-----
	/*
	 * Setter for text 
	 * 
	 * @param w - the text for Word object 
	 */
	public void setText(String w) {
		this.text = w; 
	}
	
	/*
	 * Setter for fileNames 
	 * 
	 * @param fileNames - the list of file names that contain the Word's text 
	 */
	public void setFileList(ArrayList<String> fileNames) {
		this.fileList = fileNames; 
	}
	
	//------GETTERS-----
	/*
	 * Getter for text 
	 */
	public String getText() {
		return this.text;
	}
	
	/*
	 * Getter for fileList 
	 */
	public ArrayList<String> getFileList() {
		return this.fileList; 
	}
	
	//---OTHER METHODS---
	/*
	 * Add a file name to the list of file names for text 
	 */
	public void addFile(String fileName) {
		this.fileList.add(fileName); 
	}
	
	/*
	 * Compare two objects of type Word 
	 */
	public int compareTo(Word other) {
		return this.text.compareTo(other.text); 
	}
	
	/*
	 * Return a String with information about this Word 
	 */
	public String toString() {
		return ("files containing "+this.text+ ": " + fileListToString()); 
	}
	
	/*
	 * Convert the fileList to a single String without brackets  
	 */
	private String fileListToString() {
		String fileListStr = ""; 
		for (int i = 0; i < fileList.size(); i++ ) {
			fileListStr += fileList.get(i) + " "; 
		}
		return fileListStr; 
	}
	
}
