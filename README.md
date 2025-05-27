## Steps to execute the file
* Download Java Development Kit8 from the link provided here https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* Download the Netbeans IDE from the link provided here
    https://netbeans.org/downloads/
* Open Netbeans and select file in the menu available at left top corner
* Select open project from menu list and select the file provided
* Select the project and double click to open and build the project by selecting play button available in menu above.
* To see the BST graph go to command line, install GraphViz and give the command
dot -Tpng BSTtree.dot > output.png

## Project Description
Compress a given text file using Huffman Coding and decode it back to get the original text file.
### Inputs
* Input text file which needs to be compressed.

### Outputs
* Prints the generated Huffman code for each character
* Compressed file encoded using the generated Huffman code
* Decoded text file
* Outputs the following statistics :-
    * Size of the file before Compression
    * Size of the file after Compression
    * Compression Achieved in terms of Percentage

### Program Analysis
General Flow of Program
1. Reads the input file and copy its content to a String
2. Extracts each character from the string store it into a character array.
3. Finds the frequency of each character and store them in an integer array at the corresponding indices as the character array
4. Insert each character into a priority queue according to the frequency
5. Take the lowest two frequencies and find their sum
6. Insert into priority queue a new node with frequency as the calculated sum and remove the lowest two nodes.
7. Repeat the Steps 5 and 6 until the heap is empty
8. Build the path of Huffman code by assigning 0 to left and 1 to right and save the created code into an array at corresponding indices as the character array
9. Insert each character and their Huffman codes into a BST
10. Search the BST for each character in the input text and write the codes into an output file
11. Print out the Huffman codes for each character
12. A dot file will be generated with the formed BST
13. Create a bin file for the Huffman code
14. Decode the file containing the codes using the Huffman code by tracing back the path.
15. Convert the codes back to the corresponding characters and write them into an output file.


### Data Structures and Algorithms used in the Program
* MinHeapify
* Huffman coding algorithm
* Binary Search tree algorithm
* Arrays, Linked lists
  
### Analysis of Program
* It took 50.064405 ms to encode a file of size 17984 bits
* A compression rate of 43.44 was obtained.
* It took 45.736861 ms to decode the file
* The complexity of the algorithm will be O(n log n)
