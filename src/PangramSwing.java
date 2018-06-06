package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

class PangramSwing extends JFrame {

	private JPanel contentPane;
	private JTextField enteredString;

	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PangramSwing frame = new PangramSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.
	public PangramSwing() {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterAString = new JLabel("Enter a String:");
		lblEnterAString.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterAString.setForeground(new Color(0, 0, 0));
		lblEnterAString.setBounds(20, 24, 100, 20);
		contentPane.add(lblEnterAString);
		
		enteredString = new JTextField();
		enteredString.setBounds(20, 50, 247, 20);
		contentPane.add(enteredString);
		enteredString.setColumns(10);
		
		JLabel informationPangram = new JLabel("");
		informationPangram.setEnabled(false);
		informationPangram.setBounds(20, 130, 389, 46);
		contentPane.add(informationPangram);
		
		JButton btnUseString = new JButton("Use String");
		btnUseString.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//enteredString.disable();
				checkPangram strPan = new checkPangram(enteredString.getText());
				strPan.checkString();
				
				if(strPan.checkString() == 1) {
					informationPangram.setText("Your string is a pangram!");
				} else {
					informationPangram.setText("Your string is not a pangram, there are letters missing...");
				}
			}
		});
		btnUseString.setBounds(20, 81, 118, 23);
		contentPane.add(btnUseString);
	}
}

// check the string if it´s a pangram
class checkPangram {
	checkPangram(String s) {
		str = s;
	}
	
	String str;
	char strLetters[] = new char[26]; 
	int counter = 0;
	int isPangram = 0;
	
	int checkString() {
		for(int i = 0; i < str.length(); i++) {
			char letter = Character.toLowerCase(str.charAt(i));
			int letterCount = 0;
			
			if(letter >= 'a' && letter <= 'z') {
				for(int a = 0; a < strLetters.length; a++) {
					if(letter != strLetters[a]) {
						letterCount++;
						if(letterCount == 26) {
							strLetters[counter] = letter;
							counter++;
						}
					}
				}
			}
		}
		Arrays.sort(strLetters);
		
		if(strLetters[25] == 'z' && strLetters[0] == 'a') {
			isPangram = 1;
		} else {
			isPangram = 0;
		}
		
		return isPangram;
	}
}
