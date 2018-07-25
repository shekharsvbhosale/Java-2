package main;

/* Reverse an int
 * input is given
 * output is shown in the console
 *
 */

class NumberReverse {
	public static void main (String args[]) {
		int num = 123456;
		int offset = 0;
		int i;
		
		// change the int to be a string
		String strNum = Integer.toString(num);
		
		StringBuilder strRev = new StringBuilder("");
		
		System.out.println("String before: " + strNum);
		System.out.println("String has " + strNum.length() + " letters");
		System.out.println();
		
		for(i = strNum.length()-1; i >= 0; i--) {
			strRev.insert(offset, strNum.charAt(i));
			offset++;
		}
		
		// convert the reversed string back to an int
		int numRev = Integer.parseInt(strRev.toString());
		
		System.out.println("String afterwards: " + numRev);
	}
}
