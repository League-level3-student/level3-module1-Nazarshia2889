import java.util.ArrayList;
import java.util.Random;

public class Checkpoint {
	public static void main(String[] args) {
		Random rand = new Random();
		int numberOfCows = rand.nextInt(10); 
		ArrayList<Cow> cows = new ArrayList<Cow>(numberOfCows);
		for(int i = 0;i<numberOfCows;i++) {
			Cow x = new Cow();
			cows.add(x);
		}
		for(int i = 0;i<cows.size();i++){
			Cow x = cows.get(i);
			x.feed();
		}
	}

}

class Cow {
    public void feed(){
    	System.out.println("Cow has been fed.");
    }
  }