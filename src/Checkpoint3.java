import java.util.HashMap;

public class Checkpoint3 {
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("Hello", "Bonjour");
		hm.put("Bye", "Au revoir");
		hm.put("Yes", "Oui");
		hm.put("No", "Non");
		hm.put("Thank you", "Merci");
		
		System.out.println("English and French");
		
		for(String s : hm.keySet()){
			System.out.println("Key: " + s + " —  Value: " + hm.get(s));
		}
	}
}
