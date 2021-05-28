I have neither given nor received unauthorized aid on this assignment. -Katie Macalintal 


HW5
BinarySearchTree.java and Word.java - Code in here is obvious for all I did was follow the guidelines and reference the sample output. 


FileSearcher.java 
main() - This method functions as directed through the guidelines. It accounts for any extra spaces the user may include in their answers through String’s strip() method and communicates with the user when they have entered an invalid choice. 


findWord() - The main method calls this method when the user wants to search for a word. This method checks if our BinarySearchTree with all the words in the files (wordTree) contains the word the user is searching for (wordToFind). It prints the appropriate information based on whether the BST contains wordToFind. This method creates a new Word object out of the String wordToFind because BST holds objects of type Word. 


scanFiles() - This method, written with the help of the pseudo-code from class, processes every word in every file in the directory and updates or adds each word in every file to our BST of words (wordTree). It completes these tasks by calling the addTextToBST() method, in order to read and process every word in a text file. 


getWordsFromFile() - This method processes the contents/words of a text file (file), stores every word without punctuation in an array of Strings, and later returns that array (fileWords). In order to read the file and have all the contents in one variable, I created a String variable (fileContents) where every line of the file is eventually added to. I then iterated through every character in fileContents to take out punctuations in the String. Since I could not find a way to delete a single character, I decided to create another String variable (fileModified), which eventually held every character in the original file except for punctuations (eg. letters, digits, spaces). I decided to keep the spaces because we would later need to differentiate between different words. Keeping the spaces in the String enabled me to utilize String’s split() method and break up the contents into an array of Strings, where each element represents a word in the text file.  


addTextToBST() - This method updates or adds every word from a text file to our BST of Words (wordTree). It obtains all the words by calling getWordsFromFile() and follows the pseudo-code discussed in class. 




HW5-Extra 
Word.java - Based on the guidelines and the output provided, I decided to rename one of my data fields (fileList was changed to textFiles) to be more clear and added two new data fields to the Word object (directoryNames and fileNames). Because a word can be found in more than one directory or file name, I decided to make those data fields of type ArrayList<String>. I then created setter, getter, and adding methods to those new data fields. I had also edited the toString() to follow what was provided in the guidelines and, similar to before, created methods that modified the contexts in directoryNames and fileNames for a simpler print. 


FileSearcher.java - Only the changes I made from the original are discussed 
scanFiles() - This method is essentially the same as the regular scanFiles(), but instead it also adds the names of the directories and files to the BST (wordTree) by calling addDirectoryNameToBST() and addFileNameToBST() when appropriate. I had the addDirectoryNameToBST() as the first line of the method because the name starting directory’s name needs to be accounted for as well. If it is put under the if statement that checks if the file is a directory, then the name of the starting directory will not be accounted for. Then, logically I called the addFileNameToBST() when the contents of a file were about to be processed. 


addDirectoryNameToBST() and addFileNameToBST() - These two functions essentially do the same thing: they add the name of the directory or file to the BST (wordTree) as a Word object. The reason why I decided to put them in two different methods is because the names of directories and the names of files are two different data fields for the Word object. This means differentiating between when a directory name is a certain word and when a file name is a certain word is important because two different data fields of the Word object will have to be modified. 


addTextFileToBST() - Same method as addTextToBST(), I just changed its name so that it is more specific. 


Bugs
* scanFiles() only works when a directory is passed through. This means that a directory must be passed through as the first argument in the command line.
* Apostrophes will also be taken out of the files being processed and read. 