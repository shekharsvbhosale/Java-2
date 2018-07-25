package main;

import javax.swing.JOptionPane;

/*	Program to check if a number is valid with the Luhn Algorithm (credit cards, some account numbers of banks or social security numbers of Canada)
 * 	Output and input with JOptionPane
 */

public class LuhnAlgorithm {
	
	boolean isValid(String num) {
		StringBuilder afterLuhn = new StringBuilder(num);
		int result = 0;
		
		// double all digits starting with the second from the right
		for(int i = num.length() - 2; i >= 0; i -= 2) {
			int digit = Character.getNumericValue(num.charAt(i));
			result = digit + digit;
			
			// if the result of the double is greater than 9, calculate the cross sum of the number
			if(result > 9) {
				String digits = Integer.toString(result);
				result = 0;
				
				for(int a = 0; a < digits.length(); a++) {
					int digitNew = Character.getNumericValue(digits.charAt(a));
					result += digitNew;
				}
			}
			
			//replace the old digit with the new one
			afterLuhn.replace(i, i + 1, Integer.toString(result));
		}
		
		result = 0;
		
		// sum up all the digits of the number
		for(int i = 0; i < afterLuhn.length(); i++) {
			int digitToSum = Character.getNumericValue(afterLuhn.charAt(i));
			result += digitToSum;
		}
		
		// check if result mod 10 = 0
		if(result % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	String parseString(String input) {
		StringBuilder cleanInput = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >= '0' && input.charAt(i) <= '9') 
				cleanInput.append(input.charAt(i));
		}
		
		//check if the entered number has at least two digits
		if(cleanInput.length() <= 1) {
			String error = "Error";
			return error;
		}
		
		return cleanInput.toString();
	}

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Please enter your credit card number:");
		LuhnAlgorithm number = new LuhnAlgorithm();
		String parsedInput = number.parseString(input);
		
		if(parsedInput == "Error") {
			JOptionPane.showMessageDialog(null, "Enter at least two digits!");
		} else {
			if(number.isValid(parsedInput)) {
				JOptionPane.showMessageDialog(null, input + " is a valid number.");
			} else {
				JOptionPane.showMessageDialog(null, "This is not a valid number!");
			}
		}
	}
}
