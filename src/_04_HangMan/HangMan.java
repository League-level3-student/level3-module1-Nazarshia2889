package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	Utilities u = new Utilities();
	Stack<String> words = new Stack<String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	String current;
	 
	
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.run();
	}
	
	void run() {
		String numberOfWords = JOptionPane.showInputDialog(null, "How many words do you want to play with.");
		int number = Integer.parseInt(numberOfWords);
		for(int i = 0; i<number; i++) {
			String x = u.readRandomLineFromFile("dictionary.txt");
			if(words.contains(x)) {
				String y = u.readRandomLineFromFile("dictionary.txt");
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
		
		current = words.pop();
		String lines = "";
		for(int i = 0; i<current.length();i++) {
			lines += "_";
			label.setText(lines);
		}
		
		frame.pack();
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		char c = e.getKeyChar();
		
		String x = label.getText();
		char[] answer = x.toCharArray();
		
		char[] characters = current.toCharArray(); 
		
		for(int i = 0;i<characters.length;i++) {
			if(characters[i] == c) {
				answer[i] = c; 
				String result = new String(answer);
				label.setText(result);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
