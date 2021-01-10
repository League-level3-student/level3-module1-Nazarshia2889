import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Checkpoint2 {
	public static void main(String[] args) {
		Stack<Integer> nums = new Stack<Integer>();
		Random rand = new Random();
		int randomNumber = rand.nextInt(10);
		int sum = 0;
		for(int i = 0;i<randomNumber;i++) {
			int random = rand.nextInt(100);
			nums.push(random);
		}
		for(int i = 0;i<nums.size();i++) {
			int x = nums.pop();
			sum += x;
		}
		
		JOptionPane.showMessageDialog(null, "The total sum of all the numbers is: " + sum);
		
	}

}
