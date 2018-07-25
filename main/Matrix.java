package main;

/*	Program to convert a String to a matrix array
 * 	Input is given, output via console
 */

public class Matrix {
	
	public static void main(String[] args) {
		String str = "9 8 7\n5 3 2\n6 6 7";
		StringBuilder strBuild = new StringBuilder();
		char[][] matrix = new char[3][3];
		System.out.println(str);
		System.out.println();
		
		// remove all unnecessary characters of the string
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '1' && str.charAt(i) <= '9')
				strBuild.append(str.charAt(i));
		}
		
		
		for(int i = 0; i < 3; i++) {
			for(int row = 0; row < 3; row++) {
				matrix[i][row] = strBuild.charAt(0);
				strBuild.deleteCharAt(0);
			}
		}
		
		for(char[] row : matrix) {
			for(char digit : row) {
				System.out.print(digit + " ");
			}
			System.out.println();
		}
	}

}
