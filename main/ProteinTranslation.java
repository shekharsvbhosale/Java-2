package main;

import javax.swing.JOptionPane;

/* Program to translate RNA sequences to proteins
 * the RNA is broken to codons and then translated to a polypeptide
 * example RNA to try out: AUGUUUUCUUAAAUG
 * this program doesn´t serve all possible cases of RNA translation, it was written to check the example
 */

public class ProteinTranslation {
	
	String RNAToProteins(String str) {
		StringBuilder rna = new StringBuilder(str);
		StringBuilder proteins = new StringBuilder(" ");
		StringBuilder protein = new StringBuilder();
		
		proteinetranslation:
		for(int i = 0; i <= (str.length() / 3); i++) {
			
			for(int a = 0; a < 3; a++) {
				protein.append(rna.charAt(a));
			}
			
			switch(protein.toString()) {
			case "AUG": proteins.append("Methionine");
						break;
			case "UUU": 
			case "UUC": proteins.append("Phenylalanine");
						break;
			case "UUA":
			case "UUG": proteins.append("Leucine");
						break;
			case "UCU":
			case "UCC":
			case "UCA":
			case "UCG": proteins.append("Serine");
						break;
			case "UAU":
			case "UAC": proteins.append("Tyrosine");
						break;
			case "UGU":
			case "UGC": proteins.append("Cysteine");
						break;
			case "UGG": proteins.append("Tryptophan");
						break;
			case "UAA":
			case "UAG":
			case "UGA": proteins.append("STOP");
						break proteinetranslation;
			}
			
			if(i < (str.length() / 3)) 
				proteins.append(", ");
			
			rna.delete(0, 3);
			protein.delete(0, 3);
		}
		
		return proteins.toString();
	}

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter a rna sequence:");
		ProteinTranslation sequence = new ProteinTranslation();
		
		JOptionPane.showMessageDialog(null, "The proteins of the sequence " + input + " are:" + sequence.RNAToProteins(input));
	}
	
}
