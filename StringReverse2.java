
class StringReverse2 { 
	
	public static void main(String args[]) {
		String str = "Today";
		
		StringBuilder strRev = new StringBuilder(str);
		
		System.out.println("String before: " + str);
		System.out.println("The String has " + str.length() + " letters.");
		
		strRev.reverse();
		
		System.out.println("\nReversed String: " + strRev.toString());
	}
}
