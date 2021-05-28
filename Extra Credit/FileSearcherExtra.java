// I have neither given nor received unauthorized aid on this assignment. 

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileSearcherExtra {
public static BinarySearchTree<Word> wordTree = new BinarySearchTree<Word>(); // Global variable for our words in every file
	
	/*
	 * This method allows the user to interact with the words in files in a directory. 
	 * 
	 * The program reads the name of a directory from the command line. It then processes all of the files in its directory 
	 * and stores each word present in each file in our BinarySearchTree (wordTree). It repeatedly asks the user to choose between 3
	 * different actions (a, s, q). 
	 */
	public static void main(String[] args) throws IOException{

		scanFiles(new File (args[0])); // Read the directory name from the command line and process all of its files 
		
		Scanner scan = new Scanner(System.in); // For scanning user's input 
		
		// Repeatedly ask user to choose between 3 different actions 
		// a - displays all words present in any file in the directory, 
		// s - search for a certain word and display all of the files that contain the word 
		// q - quit 
		boolean running = true; 
		while (running == true) {
			
			System.out.print("Please enter a command (a, s, or q) >> ");
			char choice = scan.nextLine().strip().toLowerCase().charAt(0); // User's choice 
			
			// Print appropriate information based on their choice 
			if (choice == 'a') 
				wordTree.printTree(); 
			else if (choice == 's') {
				System.out.print("Word to find >> ");
				String wordToFind = scan.nextLine().strip(); 
				findWord(wordToFind); 
			} else if (choice == 'q') 
				running = false; 
			else // Invalid letter 
				System.out.println("Please enter a valid choice."); 
			
			System.out.println(); 
		}
		
		scan.close(); 
		
	}
	
	
	/*
	 * Check if our BinarySearchTree contains a certain word. 
	 * Print the appropriate information if it is or is not in the tree. 
	 * 
	 * @param word is the word (as a String) that we looking for 
	 */
	public static void findWord(String wordToFind) {
		Word w = new Word(wordToFind); // Must create a Word object bc that is the object type of the BST 
		
		if (wordTree.contains(w)) {
			System.out.println( wordTree.find(w) ); // Prints with the format declared in the toString method 
		} else { // w is not in tree
			System.out.println(wordToFind + " is not found."); 
		}
	}
	
	/*
	 * Process every directory name, every file name, and every word in every file in our directory. 
	 * Add or update all of these words in the BST of words. 
	 * 
	 * @param folder is a directory to process 
	 */
	public static void scanFiles(File folder) throws IOException{
		addDirectoryNameToBST(folder); //want to account for every directory's name 
		
		// Get all files/sub directories in our folder 
		File[] list = folder.listFiles(); 
		
		// Process each file in the directory 
		for (int i = 0; i < list.length; i++) {
			File file = list[i]; // Current file we are on 
			if(!file.isHidden() && file.getName().charAt(0)!= '.') { // Make sure we are not working with hidden files 
				if (file.isDirectory()) { // file is a directory with even more files 
					scanFiles(file); 
				} else { // file is a text file 
					addFileNameToBST(file); // want to account for the text file name 
					// Process the file and its contents
					addTextFileToBST(file); 
				}
			}
		}
	}
	
	/*
	 * Read/Process the file by getting rid of all the punctuation and storing every word in the file in an Array of Strings. 
	 * 
	 * BUG: This will also get rid of apostrophes 
	 * 
	 * @param file is the specific text file being processed 
	 * @return array of Strings - all the words in the file 
	 */
	public static String[] getWordsFromFile(File file) throws IOException{
		Scanner fr = new Scanner((file)); //Read the file
		String fileContents = ""; 
		
		// Store every line and word in the file as a single String 
		while (fr.hasNextLine()) {
			fileContents += fr.nextLine(); 
		}
		
		// Modify the original contents of file by getting rid of all the punctuation 
		String fileModified = ""; 
		for (int i = 0; i < fileContents.length(); i++ ) {
			char currentChar = fileContents.charAt(i); 
			// Only add the character if it is a space, digit, or letter 
			if (currentChar == ' ') 
				fileModified += currentChar; 
			else if (Character.isDigit(currentChar))
				fileModified += currentChar; 
			else if (Character.isLetter(currentChar))
				fileModified += currentChar; 
		}
		
		// Store the modified contents of our file (all the words without punctuation) as an Array of Strings
		String[] fileWords = fileModified.split(" "); // Array of all our words in the file 
		
		fr.close(); 
		
		return fileWords; 
	}
	
	/*
	 * Update or add our directory name as a Word in our BST. 
	 * 
	 * @param directory being processed 
	 */
	public static void addDirectoryNameToBST(File directory) {
		Word w = new Word(directory.getName()); 
		
		if (wordTree.contains(w)) {  // w is already in the tree, update the w's directoryNames 
			wordTree.find(w).addDirectoryName(directory.getName());
		} else {
			w.addDirectoryName(directory.getName());
			wordTree.insert(w);
		}
	}
	
	/*
	 * Update or add our file name as a Word in our BST. 
	 * 
	 * @param file being processed 
	 */
	public static void addFileNameToBST(File file) {
		Word w = new Word(file.getName()); 
		
		if (wordTree.contains(w)) { // w is already in the tree, update the w's fileNames 
			wordTree.find(w).addFileName(file.getName());
		} else {
			w.addFileName(file.getName());
			wordTree.insert(w);
		}
	}
	
	/*
	 * Add to or update every word in a text file in the BST. 
	 * 
	 * @param file is the specific text file being processed 
	 */
	public static void addTextFileToBST(File file) throws IOException {
		
		String[] words = getWordsFromFile(file); // all the words in the file w/o punctuation 
		
		// Go through every word in the file  
		for (int i = 0; i < words.length; i++) {
			Word w = new Word(words[i]); // bc BST holds object type Word and our key is the text 
			
			if (wordTree.contains(w)) { // w is already in the tree, update the w's textFiles 
				wordTree.find(w).addTextFile(file.getName());
			} else { // w is not in tree, add it to the tree 
				w.addTextFile(file.getName());
				wordTree.insert(w);
			}
		}
	}
	

}

