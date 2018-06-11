package src;

import javax.swing.JOptionPane;

/* Program to translate an RNA to proteines
 * the RNA is broken to codons and then translated to a polypeptide
 * example RNA to try out: AUGUUUUCUUAAAUG
 * this program doesn´t serve all possible cases of RNA translation, it was written to check the example
 */

public class ProteinTranslation {
	
	String RNAToProteins(String str) {
		StringBuilder rna = new StringBuilder(str);
		StringBuilder proteines = new StringBuilder(" ");
		StringBuilder proteine = new StringBuilder();
		
		proteinetranslation:
		for(int i = 0; i <= (str.length() / 3); i++) {
			
			for(int a = 0; a < 3; a++) {
				proteine.append(rna.charAt(a));
			}
			
			switch(proteine.toString()) {
			case "AUG": proteines.append("Methionine");
						break;
			case "UUU": 
			case "UUC": proteines.append("Phenylalanine");
						break;
			case "UUA":
			case "UUG": proteines.append("Leucine");
						break;
			case "UCU":
			case "UCC":
			case "UCA":
			case "UCG": proteines.append("Serine");
						break;
			case "UAU":
			case "UAC": proteines.append("Tyrosine");
						break;
			case "UGU":
			case "UGC": proteines.append("Cysteine");
						break;
			case "UGG": proteines.append("Tryptophan");
						break;
			case "UAA":
			case "UAG":
			case "UGA": proteines.append("STOP");
						break proteinetranslation;
			}
			
			if(i < (str.length() / 3)) 
				proteines.append(", ");
			
			rna.delete(0, 3);
			proteine.delete(0, 3);
		}
		
		return proteines.toString();
	}

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter a rna sequence:");
		ProteinTranslation sequence = new ProteinTranslation();
		
		JOptionPane.showMessageDialog(null, "The proteins of the sequence " + input + " are:" + sequence.RNAToProteins(input));
	}
	
}
