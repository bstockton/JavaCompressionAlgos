package huffmanCompression;

import java.io.File;
import java.nio.file.Paths;

/**
 * Class to test and time the Huffman algorithm to determine the optimal number of words to use for compressing the text.
 * Warning, all verbose flags should be off to run this. I also advise modifying the compress_file method so it does not write the
 * file every time the data is compressed. This is what I did during testing.
 * @author Brent Collins
 *
 */

public class HuffmanTiming {

	public static void main(String[] args) {
		HuffmanTreeUsingWords huffman;

		String file_name = "";
		
	
		
		//choose a file to use
		//file_name = "Resources\\norvig_big";
		//file_name = "Resources\\two_cities";
		//file_name = "Resources\\constitution";
		// file_name = "Resources\\green_eggs_and_ham";
		// file_name = "Resources\\alphabetplus";
		// file_name = "Resources\\alphabet";
		// file_name = "Resources\\simple";
		// file_name = "Resources\\a_few_letters";

		
		// get baseline scores
		huffman = new HuffmanTreeUsingWords(0);
		

		long startTime = System.nanoTime();
		huffman.compress_file(new File(file_name), new File(file_name + "." + huffman.WORD_COUNT + ".huf"));
		long elapsed = System.nanoTime() - startTime;
		double baseTime = elapsed;
		double baseRatio = huffman.originalSize / (double) huffman.compressedSize;
		
		System.out.println(huffman.originalSize);
		
		for(int i = 0; i < 25001; i+=500) {
			huffman = new HuffmanTreeUsingWords(i);
			
			startTime = System.nanoTime();
			huffman.compress_file(new File(file_name), new File(file_name + "." + huffman.WORD_COUNT + ".huf"));
			elapsed = System.nanoTime() - startTime;
			double newTime = elapsed;
			double newRatio = huffman.originalSize / (double) huffman.compressedSize;
			double wordsUsedRatio = huffman.WORD_COUNT / (double) huffman.uniqueWords;
			
			double weiss = weissmanScore(1.0, baseRatio, newRatio, baseTime, newTime);
			System.out.println(weiss + "\t" + newRatio + "\t" + toRegTime(elapsed) + "\t" + wordsUsedRatio);
		}
		

	}

	/**
	 * convert from nano seconds to regular seconds
	 * 
	 * @param nanoseconds
	 * @return - seconds
	 */
	public static double toRegTime(double nanoseconds) {
		return nanoseconds / 1_000_000_000;
	}

	public static double weissmanScore(double alpha, double baseRatio, double newRatio, double baseTime,
			double newTime) {

		double ws = alpha * (newRatio / baseRatio) * (Math.log(baseTime) / Math.log(newTime));
		return ws;
	}

}
