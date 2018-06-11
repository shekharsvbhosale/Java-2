package src;

import javax.swing.JOptionPane;

/* Program to calculate the difference in the square of the sum and the sum of the squares of n natural numbers 
 * input and output via JOptionPane
 */

public class DifferenceOfSquares {
	
	int squareOfSum(int num) {
		int result = 0;
		
		for(int i = 1; i <= num; i++) {
			result += i;
			
			if(i == num) 
				result = (int) Math.pow(result, 2);
		}
		
		return result;
	}
	
	int sumOfSquares(int num) {
		int result = 0;
		
		for(int i = 1; i <= num; i++) {
			result += Math.pow(i, 2);
		}
		
		return result;
	}
	
	int differenceOfResults(int num) {
		int result = squareOfSum(num) - sumOfSquares(num);
		return result;
	}

	public static void main(String[] args) {
		DifferenceOfSquares num1 = new DifferenceOfSquares();
		
		int number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number to calculate the differences of the Squares:"));
		
		JOptionPane.showMessageDialog(null, "The result is: " + num1.differenceOfResults(number));
	}

}
