package main;

import javax.swing.JOptionPane;

/* Program to check if a ISBN number is a valid ISBN-10
 * Input and output with JOptionPane
 */

public class ISBNVerifier {
	
	boolean checkISBN(String isbn) {
		int result = 0;
		int b = 10;
		
		for(int i = 0; i < isbn.length(); i++) {
			int a = (int) isbn.charAt(i); 		
			result += a * b;
			b--;
		}
		
		if(result % 11 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean parseInput(String str) {
		StringBuilder buildISBN = new StringBuilder();

		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch >= '0' && ch <= '9') {
				buildISBN.append(ch);
			}
		}
		
		return checkISBN(buildISBN.toString());
	}
	
	public static void main(String args[]) {
		String str = JOptionPane.showInputDialog("Enter an ISBN number to check if it´s valid:");
		ISBNVerifier ISBN = new ISBNVerifier();
		
		if(ISBN.parseInput(str)) {
			JOptionPane.showMessageDialog(null, str + " is a valid ISBN-10 number.");
		} else {
			JOptionPane.showMessageDialog(null, "This is not a valid ISBN-10  number!");
		}
	}
}
