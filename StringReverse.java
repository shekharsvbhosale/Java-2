class StringReverse { 
	
	public static void main(String args[]) {
		String str = "Today";
		int offset = 0;
		int i;
		
		StringBuilder strRev = new StringBuilder("");
		
		System.out.println("String before: " + str);
		System.out.println("String has " + str.length() + " letters");
		System.out.println();
		
		for(i = str.length()-1; i >= 0; i--) {
			strRev.insert(offset, str.charAt(i));
			offset++;
		}
		
		System.out.println("String afterwards: " + strRev.toString());
	}
}
