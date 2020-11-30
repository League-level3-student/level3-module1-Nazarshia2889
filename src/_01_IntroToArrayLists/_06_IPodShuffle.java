package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton surprise = new JButton();
	ArrayList<Song> listOfSongs = new ArrayList<Song>();
	Random rand = new Random();
	Song currentSong;
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		Song d = new Song("demo.mp3");
		Song g = new Song("Guitar.mp3");
		Song e = new Song("Electronic.mp3");
		Song p = new Song("Piano.mp3");
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

		listOfSongs.add(d);
		listOfSongs.add(g);
		listOfSongs.add(e);
		listOfSongs.add(p);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.add(surprise);
		
		surprise.addActionListener(this);
		surprise.setText("Surprise Me!");
		
		frame.pack();
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentSong != null) {
			currentSong.stop();
		}
		JButton buttonPressed = (JButton) e.getSource();
		int x = rand.nextInt(listOfSongs.size());
		Song s = listOfSongs.get(x);
		currentSong = s;
		
		if(buttonPressed == surprise) {
			s.play();
		}
	}
}