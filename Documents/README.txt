README: 

---------------------------------------------------------------
AUTHOR INFORMATION
---------------------------------------------------------------

Date:				04/25/2017
Name:		Brent Collins


---------------------------------------------------------------
Project Summary
---------------------------------------------------------------

	In this project we implemented Huffman coding. We encoded and 
	decoded text using Huffman trees to represent the data in a 
	compressed format. A Huffman tree is a frequency sorted tree based data 
	structure.
1) HuffmanTreeUsingWords
	HuffmanTreeUsingWords is a priority queue, specifically heap
	of Nodes, where the traversal of the tree will give the optimal
	prefix code for symbols in text



---------------------------------------------------------------
Design Decisions
---------------------------------------------------------------

camelCase styling

Compute most common word implementation:

	The Author felt a hash table was the best data structure
	to use for this method because of its speed. We then dumped
	the objects into an array for sorting, empirically this was
	the fastest way to implement that method.





