package main;

import javax.swing.JOptionPane;

/* Program to calculate the Scrabble Score of a word
 * input and output with JOptionPane
 */

public class Scrabble {
	
	int scoreLetters(String s) {
		s = s.toLowerCase();
		int score = 0;
			
		for(int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
	
			switch(letter) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'l':
				case 'n':
				case 'r':
				case 's':
				case 't': score += 1;
						  break;
				case 'd':
				case 'g': score += 2;
						  break;
				case 'b':
				case 'c':
				case 'm':
				case 'p': score += 3;
						  break;
				case 'f':
				case 'h':
				case 'v':
				case 'w':
				case 'y': score += 4;
						  break;
				case 'k': score += 5;
						  break;
				case 'j':
				case 'x': score += 8;
						  break;
				case 'q':
				case 'z': score += 10;
						  break;
			}
		}	
		return score;
	}
	
	public static void main(String args[]) {
		String str = JOptionPane.showInputDialog("Enter a word you want to score for Scrabble:");
		Scrabble word = new Scrabble();
			
		JOptionPane.showMessageDialog(null, "The Scrabble score is: " + word.scoreLetters(str));
	}
}
