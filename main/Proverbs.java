package main;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/* Program to genereate a fixed proverb with the given input
 * Input is organized in single words by using the class Scanner
 */

public class Proverbs extends JFrame {

	private JPanel contentPane;
	private JTextField words;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proverbs frame = new Proverbs();
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
	public Proverbs() {
		setTitle("Generate proverbs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrDoYouKnow = new JTextArea();
		txtrDoYouKnow.setEditable(false);
		txtrDoYouKnow.setFont(new Font("Dialog", Font.BOLD, 11));
		txtrDoYouKnow.setBackground(UIManager.getColor("Button.background"));
		txtrDoYouKnow.setLineWrap(true);
		txtrDoYouKnow.setWrapStyleWord(true);
		txtrDoYouKnow.setText("Do you know the proverb \"For a horseshoe nail, a kingdom was lost\"? Go on and generate your own proverbs. Just enter a list of words you want to combine. For one proverb you need 2 words!");
		txtrDoYouKnow.setBounds(10, 21, 386, 50);
		contentPane.add(txtrDoYouKnow);
		
		words = new JTextField();
		words.setToolTipText("");
		words.setBounds(10, 76, 354, 20);
		contentPane.add(words);
		words.setColumns(10);
		
		JTextArea result = new JTextArea();
		result.setEditable(false);
		result.setBackground(UIManager.getColor("Button.background"));
		result.setLineWrap(true);
		result.setWrapStyleWord(true);
		result.setBounds(10, 107, 401, 132);
		contentPane.add(result);
		
		JButton btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = separateWords(words.getText());
				
				// check if the number of words is even = odd number returns an empty array from seperateWords()
				if(args.length == 0) {
					result.setText("");
					result.append("Please enter an even number of words!");
				} else {
					String[] proverbs = buildProverb(args);
					result.setText("");
					
					for(int i = 0; i < args.length; i++) {
						result.append(proverbs[i]);
					}
				}
			}
		});
		btnGo.setMargin(new Insets(2, 7, 2, 7));
		btnGo.setFont(new Font("Dialog", Font.BOLD, 10));
		btnGo.setBounds(374, 76, 37, 20);
		contentPane.add(btnGo);
	}
	
	// seperate words in a String with the class Scanner
	String[] separateWords(String str) {
		Scanner scan = new Scanner(str);
		int howManyWords = 0;
		
		// count the number of tokens to initialize the array to keep the single words
		for(int i = 0; i < str.length(); i++) {
			// returns true if there is another token
			if(scan.hasNext())  {
				howManyWords++;
				// scanner has to be moved to the next token
				scan.next();
			}
		}
		// scanner has to be close or reset
		scan.close();
		
		// check if the number of tokens is even (there are 2 words needed to build a proverb)
		if(howManyWords % 2 != 0) {
			String[] noEvenInput = new String[0];
			return noEvenInput;
		}
		
		// initialize a new scanner to add the tokens of the input to the word array
		Scanner scan2 = new Scanner(str);
		String words[] = new String[howManyWords];
		
		for(int i = 0; i < howManyWords; i++) {
			if(scan2.hasNext()) {
			words[i] = scan2.next().toString();
			}
		}
		
		scan2.close();
		return words;
	}
	
	String[] buildProverb(String[] str) {
		String[] proverbsArray = new String[str.length];
		
		for(int i = 0; i < str.length; i+= 2) {
			StringBuilder proverbs = new StringBuilder();
			String word1 = str[i];
			String word2 = str[i+1];
			proverbs.append("For want of a " + word1 + " the " + word2 + " was lost.\n");
			proverbsArray[i] = proverbs.toString();
		}
		
		return proverbsArray;
	}
}
