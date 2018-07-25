package main;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/* program to calculate the lifetime after 1 Gigasecond which is 10^9
 * output via console and JOptionPane
 * */

public class Gigasecond {
	
	public static void main(String args[]) {
		double liveForAGigasecondInMinutes = (Math.pow(10, 9) / 60);
		double liveForAGigasecondInHours = Math.pow(10, 9) / (60 * 60);
		double liveForAGigasecondInDays = Math.pow(10, 9) / (60 * 60 * 24);
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("When your lifetime reaches one gigasecond you lived for: \n    " + df.format(liveForAGigasecondInMinutes) + 
				" minutes or\n    " + df.format(liveForAGigasecondInHours) + " hours or \n    " + df.format(liveForAGigasecondInDays) + " days");
		
		JOptionPane.showMessageDialog(null,"When your lifetime reaches one gigasecond you lived for: \n    " + df.format(liveForAGigasecondInMinutes) + 
				" minutes or\n    " + df.format(liveForAGigasecondInHours) + " hours or \n    " + df.format(liveForAGigasecondInDays) + " days");
	}
}
