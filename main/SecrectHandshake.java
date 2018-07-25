package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/* Program to generate a secret handshake based on a decimal number converted to a binary number
 * with reset button and button to show the binary code
 * input and output with Swing
 * 
 * Steps of the handshake: 
 * binary >= 1 --> wink
 * binary >= 10 --> double blink
 * binary >= 100 --> close your eyes
 * binary >= 1000 --> jump
 * binary >= 10000 --> like binary >= 1000 and reverse of the order
 */

public class SecrectHandshake extends JFrame {

	private JPanel contentPane;
	private JTextField number;
	private JTextField txtWink;
	private JTextField txtDoubleBlink;
	private JTextField txtCloseYourEyes;
	private JTextField txtJump;
	private JButton btnNewButton;
	private JTextArea binaryCode;
	private JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecrectHandshake frame = new SecrectHandshake();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecrectHandshake() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 299);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterADecimal = new JLabel("Enter a decimal number:");
		lblEnterADecimal.setBounds(10, 24, 151, 14);
		contentPane.add(lblEnterADecimal);
		
		number = new JTextField();
		number.setBounds(154, 21, 45, 20);
		contentPane.add(number);
		number.setColumns(10);
		
		txtWink = new JTextField();
		txtWink.setEnabled(false);
		txtWink.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		txtWink.setBorder(null);
		txtWink.setHorizontalAlignment(SwingConstants.LEFT);
		txtWink.setEditable(false);
		txtWink.setText("wink");
		txtWink.setBounds(20, 95, 114, 20);
		contentPane.add(txtWink);
		txtWink.setColumns(10);
		
		txtDoubleBlink = new JTextField();
		txtDoubleBlink.setEnabled(false);
		txtDoubleBlink.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		txtDoubleBlink.setText("double blink");
		txtDoubleBlink.setHorizontalAlignment(SwingConstants.LEFT);
		txtDoubleBlink.setEditable(false);
		txtDoubleBlink.setColumns(10);
		txtDoubleBlink.setBorder(null);
		txtDoubleBlink.setBounds(20, 118, 114, 20);
		contentPane.add(txtDoubleBlink);
		
		txtCloseYourEyes = new JTextField();
		txtCloseYourEyes.setEnabled(false);
		txtCloseYourEyes.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		txtCloseYourEyes.setText("close your eyes");
		txtCloseYourEyes.setHorizontalAlignment(SwingConstants.LEFT);
		txtCloseYourEyes.setEditable(false);
		txtCloseYourEyes.setColumns(10);
		txtCloseYourEyes.setBorder(null);
		txtCloseYourEyes.setBounds(20, 142, 114, 20);
		contentPane.add(txtCloseYourEyes);
		
		txtJump = new JTextField();
		txtJump.setEnabled(false);
		txtJump.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		txtJump.setText("jump");
		txtJump.setHorizontalAlignment(SwingConstants.LEFT);
		txtJump.setEditable(false);
		txtJump.setColumns(10);
		txtJump.setBorder(null);
		txtJump.setBounds(20, 165, 114, 20);
		contentPane.add(txtJump);
		
		JLabel lblDoYourSecret = new JLabel("Do your secret handshake:");
		lblDoYourSecret.setBounds(10, 68, 179, 16);
		contentPane.add(lblDoYourSecret);
		
		JButton btnGenerateHandshake = new JButton("Generate Handshake");
		btnGenerateHandshake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int binary = Integer.parseInt(decimalToBinary(Integer.parseInt(number.getText())));
				
				if(binary >= 10000) {
					txtWink.setText(txtJump.getText());
					txtDoubleBlink.setText(txtCloseYourEyes.getText());
					txtCloseYourEyes.setText("double blink");
					txtJump.setText("wink");
					
					txtWink.setEnabled(true);
					txtDoubleBlink.setEnabled(true);
					txtCloseYourEyes.setEnabled(true);
					txtJump.setEnabled(true);
				} else if (binary >= 1000) {
					txtWink.setEnabled(true);
					txtDoubleBlink.setEnabled(true);
					txtCloseYourEyes.setEnabled(true);
					txtJump.setEnabled(true);
				} else if (binary >= 100) {
					txtWink.setEnabled(true);
					txtDoubleBlink.setEnabled(true);
					txtCloseYourEyes.setEnabled(true);
				} else if(binary >= 10) {
					txtWink.setEnabled(true);
					txtDoubleBlink.setEnabled(true);
				} else if(binary >= 1) {
					txtWink.setEnabled(true);
				}  
			}
		});
		btnGenerateHandshake.setFont(new Font("Dialog", Font.BOLD, 11));
		btnGenerateHandshake.setBounds(224, 18, 151, 26);
		contentPane.add(btnGenerateHandshake);
		
		btnNewButton = new JButton("Show binary code");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryCode.setText(decimalToBinary(Integer.parseInt(number.getText())));
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 11));
		btnNewButton.setBounds(224, 92, 151, 26);
		contentPane.add(btnNewButton);
		
		binaryCode = new JTextArea();
		binaryCode.setWrapStyleWord(true);
		binaryCode.setLineWrap(true);
		binaryCode.setBackground(UIManager.getColor("Button.background"));
		binaryCode.setEditable(false);
		binaryCode.setBounds(224, 129, 151, 56);
		contentPane.add(binaryCode);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtWink.setText("wink");
				txtDoubleBlink.setText("double blink");
				txtCloseYourEyes.setText("close your eyes");
				txtJump.setText("jump");
				
				txtWink.setEnabled(false);
				txtDoubleBlink.setEnabled(false);
				txtCloseYourEyes.setEnabled(false);
				txtJump.setEnabled(false);
				
				number.setText("");
				binaryCode.setText("");
			}
		});
		btnReset.setBounds(277, 215, 98, 26);
		contentPane.add(btnReset);
	}
	
	String decimalToBinary(int num) {
		StringBuilder result = new StringBuilder();
		int rest;
		
		do {
			rest = num % 2;
			num = num / 2;
			
			if(rest == 0) {
				result.append(0);
			} else if (rest == 1) {
				result.append(1);
			}
		} while(num > 0);
		
		return result.toString();
	}
}
