package src;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int a = 1533;
		int length = Integer.toString(a).length();
		int result = 0;
		int c = 0;
		int digits[] = new int[length];
		
		//put all digits in an array as chars
		for(int i = 0; i < digits.length; i++) {
			//convert the extracted char literal to an int for storing in the array
			digits[i] = Integer.parseInt(Integer.toString(a).substring(i, i+1));
			result = result + (int) Math.pow((double) digits[i], (double) length - c);
		}
		
		System.out.println("The number has " + length + " digits\n");
		if(result == a) {
			System.out.println("The number " + a + " is an armstrong number!");
		} else {
			System.out.println("The number " + a + " is not armstrong number, the result is: " + result + ".");
		}
			
	}

}
