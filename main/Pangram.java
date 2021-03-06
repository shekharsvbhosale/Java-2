package main;

import java.util.Arrays;

/* Check a String if it�s a Pangram (a sentence, that contains all letters of the alphabet at least once)
 * Input manually
 * Output in the console
 */

class Pangram {
	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog.";
		char strLetters[] = new char[26]; 
		int counter = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char letter = Character.toLowerCase(str.charAt(i));
			int letterCount = 0;
			
			if(letter >= 'a' && letter <= 'z') {
				for(int a = 0; a < strLetters.length; a++) {
					if(letter != strLetters[a]) {
						letterCount++;
						if(letterCount == 26) {
							strLetters[counter] = letter;
							counter++;
						}
					}
				}
			}
		}
		
		Arrays.sort(strLetters);
		System.out.println("Your sentence is: " + str);

		if(strLetters[25] == 'z' && strLetters[0] == 'a') {
			System.out.println("This is a Pangram!");
		} else {
			System.out.println("This is not a Pangram, there are letters missing...");
		}
	}
}
