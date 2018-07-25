package main;

import javax.swing.JOptionPane;

/* Program to check if a number is perfect, abundant or deficient based on its aliquot sum (Nicomachus classification scheme for natural numbers)
 * input and output with JOptionPane
 */

public class AliquotSum {
	
	public static void main(String args[]) {
		int number = Integer.parseInt(JOptionPane.showInputDialog("Enter a natural number to check if it´s a perfect number:"));
		AliquotSum guess = new AliquotSum();

		JOptionPane.showMessageDialog(null, guess.isPerfect(number));
	}
	
	String isPerfect(int num) {
		int result = 0;
		String perfect = num + " is a perfect number!";
		String abundant = num + " is an abundant number.";
		String deficient = num + " is a deficient number.";
		String error = num + " is not a natural number";
		
		 // error handling for an input that is not a natural number
		if(num < 1) {
			return error;
		}
		
		for(int i = 1; i < num; i++) {
			if(num % i == 0) {
				result += i;
			}
		}
		
		if(result == num) {
			return perfect;
		} else if(result > num) {
			return abundant;
		} else {
			return deficient;
		}
	}
}