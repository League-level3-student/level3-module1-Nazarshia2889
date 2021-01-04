package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton();
	JButton search = new JButton();
	JButton viewList = new JButton();
	JButton removeEntry = new JButton();
	
	HashMap<Integer, String> hm = new HashMap<Integer, String>();

	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.run();
	}
	
	void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(addEntry);
		panel.add(search);
		panel.add(viewList); 
		panel.add(removeEntry);
		
		addEntry.addActionListener(this);
		search.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		
		addEntry.setText("Add an Entry"); 
		search.setText("Search for a person"); 
		viewList.setText("View the list of people");
		removeEntry.setText("Remove an entry from the list");
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed == addEntry) {
			String ID = JOptionPane.showInputDialog(null, "Enter an ID number: ");
			int identification = Integer.parseInt(ID);
			String name = JOptionPane.showInputDialog(null, "Enter the name: ");
			hm.put(identification, name);
		}
		else if(buttonPressed == search){
			String s = JOptionPane.showInputDialog(null, "Enter an ID number to look for: "); 
			int lookup = Integer.parseInt(s);
			if(hm.containsKey(lookup) == true) {
				JOptionPane.showMessageDialog(null, "The person at ID #" + lookup + " is named " + hm.get(lookup));
			}
			else {
				JOptionPane.showMessageDialog(null, "This user does not exist");
			}
		}
		else if(buttonPressed == viewList) {
			for(int a : hm.keySet()) {
				JOptionPane.showMessageDialog(null, "ID: " + a + "  Name: " + hm.get(a));
			}
		}
		else if(buttonPressed == removeEntry) {
			String s = JOptionPane.showInputDialog(null, "Enter an ID number to remove from the list: ");
			int lookup = Integer.parseInt(s);
			if(hm.containsKey(lookup) == true) {
				hm.remove(lookup);
				JOptionPane.showMessageDialog(null, "The entry has been removed");
			}
			else {
				JOptionPane.showMessageDialog(null, "This user does not exist");
			}
		}
		
	}
	
}
