package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton view = new JButton();
	
	ArrayList<String> guestNames = new ArrayList<String>();
			
	String result = "";
	int n = 1;
	
	void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.add(add);
		panel.add(view);
		
		add.addActionListener(this);
		view.addActionListener(this);
		add.setText("Add Name");
		view.setText("View Names");
		
		frame.pack();
	}
	
	public static void main(String[] args) {
		_02_GuestBook book = new _02_GuestBook();
		book.run();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed == add) {
			String newName = JOptionPane.showInputDialog(null, "Enter a name: ");
			guestNames.add(newName);
			result += "Guest #" + n + ": " + newName + "\n";
			n += 1;
		}
		
		else if(buttonPressed == view) {
			JOptionPane.showMessageDialog(null, result);
		}
	}
	
}
