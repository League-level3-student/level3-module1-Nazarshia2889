package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	
	Stack<String> words; 
	
	JFrame frame; 
	JPanel panel;
	JLabel label; 
	JLabel livesNumber;
	
	
	String current;
	int lives = 10;
	
	
	
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.run();
	}
	
	void run() {
		words = new Stack<String>();
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		livesNumber = new JLabel();
		
		String numberOfWords = JOptionPane.showInputDialog(null, "How many words do you want to play with.");
		int number = Integer.parseInt(numberOfWords);
		for(int i = 0; i<number; i++) {
			String x = Utilities.readRandomLineFromFile("dictionary.txt");
			if(words.contains(x)) {
				String y = Utilities.readRandomLineFromFile("dictionary.txt");
				words.push(y);
			}
			else {
				words.push(x);
			}
		}
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.addKeyListener(this);
		
		panel.add(label);
		panel.add(livesNumber);
		
		current = words.pop();
		String lines = "";
		for(int i = 0; i<current.length();i++) {
			lines += "_";
			label.setText(lines);
		}
		
		livesNumber.setText("Lives: " + String.valueOf(lives));
		
		
		
		
		frame.pack();
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		boolean found = false;
		
		char c = e.getKeyChar();
		
		String x = label.getText();
		char[] answer = x.toCharArray();
		
		char[] characters = current.toCharArray(); 
	
		
		for(int i = 0;i<characters.length;i++) {
			
			if(characters[i] == c) {
				if(answer[i] == c) {
					continue;
				}
				else {
					answer[i] = c; 
					String result = new String(answer);
					label.setText(result);
					livesNumber.setText("Lives: " + String.valueOf(lives));
					found = true;
					int count = 0;
					for(int j = 0;j<answer.length;j++) {
						if(answer[j] == '_') {
							count += 1;
						}
					}
					if(count == 0) {
						label.removeAll();
						current = words.pop();
						String lines = "";
						for(int m = 0; m<current.length();m++) {
							lines += "_";
							label.setText(lines);
						}
					}
					break;
				}
			}
		}
		if(found == false) {
			lives -= 1;
			livesNumber.setText("Lives: " + String.valueOf(lives));
			if(lives == 0) {
				String replay = JOptionPane.showInputDialog(null, "Do you want to play again? Please put Yes or No: ");
				if(replay.equalsIgnoreCase("Yes")) {
					frame.dispose();
					lives = 10;
					HangMan hm = new HangMan();
					hm.run();
				}
				else {
					System.exit(1);
				}
				}
			}
		}
	
		
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
