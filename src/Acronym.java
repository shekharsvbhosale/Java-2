package src;

import javax.swing.JOptionPane;

/* Program to generate the acronym of a given name
 * the program searches for capital letters and uses StringBuilder to append these to a new String, the acronym
 * input and output via JOptionPane
 */

public class Acronym {
	String convertToAcronym(String name) {
		StringBuilder acronymString = new StringBuilder();
		
		for(int i = 0; i < name.length(); i++) {
			char letter = name.charAt(i);
			
			if(letter >= 'A' && letter <= 'Z')
				acronymString.append(letter);
		}
		
		return acronymString.toString();
	}
	
	public static void main(String args[]) {
		String name = JOptionPane.showInputDialog(null, "Enter a name:");
		Acronym name1 = new Acronym();
		
		JOptionPane.showMessageDialog(null, "Your acronym is: " + name1.convertToAcronym(name));	
	}
}
