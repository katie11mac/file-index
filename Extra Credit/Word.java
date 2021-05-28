// I have neither given nor received unauthorized aid on this assignment. 

import java.util.ArrayList;

public class Word implements Comparable<Word>{

	private String text; // actual word (key) 
	
	private ArrayList<String> directoryNames = new ArrayList<String>(); // List of all directory names containing this word
	private ArrayList<String> fileNames = new ArrayList<String>(); // List of all file names containing this word 
	private ArrayList<String> textFiles = new ArrayList<String>(); // List of all text files containing this word 
	
	
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
	 * Setter for directoryNames 
	 * 
	 * @param directoryNames - ArrayList of the directories whose names contain text 
	 */
	public void setDirectoryNames(ArrayList<String> directories) {
		this.directoryNames = directories; 
	}
	
	/*
	 * Setter for fileNames 
	 * 
	 * @param fileNames - ArrayList of the files whose names contain text 
	 */
	public void setFileNames(ArrayList<String> fileNames) {
		this.fileNames = fileNames; 
	}
	
	/*
	 * Setter for textFiles 
	 * 
	 * @param textFiles - ArrayList of the file names containing the word text 
	 */
	public void setTextFiles(ArrayList<String> textFiles) {
		this.textFiles = textFiles; 
	}
	
	//------GETTERS-----
	/*
	 * Getter for text 
	 */
	public String getText() {
		return this.text;
	}
	
	/*
	 * Getter for directoryNames 
	 */
	public ArrayList<String> getDirectoryNames() {
		return this.directoryNames; 
	}
	
	/*
	 * Getter for fileNames 
	 */
	public ArrayList<String> getFileNames() {
		return this.fileNames; 
	}
	
	/*
	 * Getter for textFiles 
	 */
	public ArrayList<String> getTextFiles() {
		return this.textFiles; 
	}
	
	//-----ADDING METHODS-----
	/*
	 * Add directory name to the list of directory names containing the text 
	 */
	public void addDirectoryName(String directoryName) {
		this.directoryNames.add(directoryName);  
	}
	
	/*
	 * Add file name to the list of file names containing text 
	 */
	public void addFileName(String fileName) {
		this.fileNames.add(fileName); 
	}
	
	/*
	 * Add a text file name to the list of text files containing text 
	 */
	public void addTextFile(String textFileName) {
		this.textFiles.add(textFileName); 
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
		String printFormat = "word: " + this.text ; 
		
		if (!this.directoryNames.isEmpty())
			printFormat += ("\n   directory names containing " +this.text+ ": " + directoryNamesToString()); 
		
		if (!this.fileNames.isEmpty())
			printFormat += ("\n   file names containing " +this.text+ ": " + fileNamesToString());
		
		if (!this.textFiles.isEmpty())
			printFormat += ("\n   text files containing " +this.text+ ": " + textFilesToString());
		
		return (printFormat); 
	}
	
	/*
	 * Convert the directoryNames to a single String without brackets  
	 */
	private String directoryNamesToString() {
		String directoriesStr = ""; 
		for (int i = 0; i < this.directoryNames.size(); i++ ) {
			directoriesStr += this.directoryNames.get(i) + " "; 
		}
		return directoriesStr; 
	}
	
	/*
	 * Convert the fileNames to a single String without brackets   
	 */
	private String fileNamesToString() {
		String fileNamesStr = ""; 
		for (int i = 0; i < this.fileNames.size(); i++ ) {
			fileNamesStr += this.fileNames.get(i) + " "; 
		}
		return fileNamesStr; 
	}
	
	
	/*
	 * Convert the fileList to a single String without brackets   
	 */
	private String textFilesToString() {
		String textFileStr = ""; 
		for (int i = 0; i < this.textFiles.size(); i++ ) {
			textFileStr += this.textFiles.get(i) + " "; 
		}
		return textFileStr; 
	}
	
	
}
