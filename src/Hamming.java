package src;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* Strings for the dna:
	dna1 = "GAGCCTACTAACGGGAT";
	dna2 = "CATCGTAATGACGGCCT";
 * */
 
class Hamming {	
	void getDNA() {
		String dna1 = JOptionPane.showInputDialog(null, "Enter the first DNA String:");
		String dna2 = JOptionPane.showInputDialog(null, "Enter the second DNA String:");
		
		try {
			compareDNA(dna1, dna2);
		} catch(StringIndexOutOfBoundsException exc) {
			JFrame frame = new JFrame("JOptionPane");
			JOptionPane.showMessageDialog(frame, "The strings have different lengths!", "Error", 0);
		}
	}
	
	void compareDNA(String dna1, String dna2) {
		StringBuilder result = new StringBuilder();
		System.out.println(dna1);
		System.out.println(dna2);
		
		for(int i = 0; i < dna1.length(); i++) {
			char letter = dna1.charAt(i);
			char letter2 = dna2.charAt(i);
			
			if(letter == letter2) {
				result.append("  ");
				System.out.print(" ");
				
			} else {
				result.append("^ ");
				System.out.print("^");
			}
		}
		
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, dna1 + "\n" + dna2 + "\n" + result);
	}
	
	public static void main(String args[]) {
		Hamming dnaComparison = new Hamming();		
		dnaComparison.getDNA();
	}
}

