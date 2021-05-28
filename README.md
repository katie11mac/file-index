# file-index

*TAKEN DIRECTLY FROM PROJECT PROMPT* 
Most modern-day computers have File-Indexing, a feature that allows the user to search for a word among the files in the computer’s system (i.e. the feature associated with a magnifying glass on Windows and Mac machines). For this assignment, you will write a simplified version of such a program that will work with text files. Specifically, it will ask the user for a string and display all the text files in a specified directory that contain this string. The program will read the directory name as a command line argument and search the files in this directory (you may assume that this directory will be stored in the same directory as your project – i.e. where src/ and bin/ are stored, so you don’t have to worry about the path to the directory). It will respond to one of three commands from the user: all (a), search (s), and quit (q).

•	If the user enters an “a”, then the program should search the files and subdirectories in the specified directory and display, in alphabetic order, all of the words that are present in any file in this directory (or its subdirectories).

•	If the user enters an “s”, then the program should prompt the user for a word and then display all of the files that contain this word. If the user’s word is not present in any file, then the program should indicate so.  

•	Finally, if the user enters a “q”, then the program should quit. 
