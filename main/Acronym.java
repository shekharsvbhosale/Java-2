package main;

import javax.swing.JOptionPane;

/* Program to generate the acronym of a given name
 * starting letters are detected by checking an empty space before them as condition (not case sensitive)
 * input and output via JOptionPane
 */

public class Acronym {
	
	public String isConvertedToAcronym(String name) {
		StringBuilder nameToAcronym = new StringBuilder();		
		char letterBefore = ' ';
		name.toLowerCase();
		
		for(int i = 0; i < name.length(); i++) {
			char letter = name.charAt(i);
			
			if(i > 0) {
				letterBefore = name.charAt(i-1);
			}
			
			if(letterBefore == ' ')
				nameToAcronym.append(letter);
		}	
		return nameToAcronym.toString();
	}
	
	public static void main(String args[]) {
		String name = JOptionPane.showInputDialog(null, "Enter a name:");
		Acronym name1 = new Acronym();
		
		JOptionPane.showMessageDialog(null, "Your acronym is: " + name1.isConvertedToAcronym(name));	
	}
}
