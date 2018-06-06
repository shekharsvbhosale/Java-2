
class RNATranscription {
	public static void main(String args[]) {
		String rna = "G C A T G C G C A T G C";
		
		StringBuilder dna = new StringBuilder("");
		
		for(int i = 0; i < rna.length(); i++) {
			char letter = rna.charAt(i);
			switch(letter) {
				case 'G': 
					dna.append('C' + " ");
					break;	
				case 'C': 
					dna.append('G' + " ");
					break;	
				case 'T': 
					dna.append('A' + " ");
					break;	
				case 'A': 
					dna.append('U' + " ");
					break;	
			}
		}
		
		System.out.println("This is the RNA: " + rna);
		System.out.println("This is the DNA: " + dna);		
	}
}
