package src;

/* Reverse a String
 * input is given
 * output is shown in the console
 * String is reversed by using StringBuilde
 */

class NumberReverse2 {
	public static void main (String args[]) {
		int num = 123456;
		
		String numStr = Integer.toString(num);
		StringBuilder numStrRev = new StringBuilder(numStr);	
		
		System.out.println("String before: " + numStr);
		System.out.println("The String has " + numStr.length() + " letters.");
		
		numStrRev.reverse();
		
		// convert the reversed string back to an int
		int numRev = Integer.parseInt(numStrRev.toString());
		
		System.out.println("String afterwards: " + numRev);
	}
}
