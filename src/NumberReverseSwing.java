package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class NumberReverseSwing extends JFrame {

	private JPanel contentPane;
	private JTextField enteredNumber;

	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberReverseSwing frame = new NumberReverseSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.
	public NumberReverseSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterANumber = new JLabel("Enter a number:");
		lblEnterANumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterANumber.setBounds(20, 26, 147, 14);
		contentPane.add(lblEnterANumber);
		
		enteredNumber = new JTextField();
		enteredNumber.setBounds(20, 51, 147, 23);
		contentPane.add(enteredNumber);
		enteredNumber.setColumns(10);
		
		JLabel result = new JLabel("");
		result.setBounds(20, 135, 347, 57);
		contentPane.add(result);
		
		JButton btnUseNumber = new JButton("Use number");
		btnUseNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reversal myNumber = new Reversal(Integer.parseInt(enteredNumber.getText()));
				
				int reversedNumber = myNumber.reverseTheNumber();
				result.setText("This is your number reversed: " + reversedNumber);
			}
		});
		btnUseNumber.setBounds(20, 85, 109, 23);
		contentPane.add(btnUseNumber);
	}
}

class Reversal {
	Reversal(int a) {
		num = a;
	}
	
	int num;
	
	int reverseTheNumber() {		
		String numStr = Integer.toString(num);
		StringBuilder numStrRev = new StringBuilder(numStr);	
		
		numStrRev.reverse();
		
		// convert the reversed string back to an int
		int numRev = Integer.parseInt(numStrRev.toString());
		
		return numRev;
	}
}
