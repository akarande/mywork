package spoj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayOnWords {

	
	public int getMatchingBeginning(char letter, List<String>words) {
		int index = 0;
		for(String w : words) {
			if(letter == w.charAt(0)) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public void solve(List<String>input) {
		boolean allUsed = true;
		Map<Integer, Boolean>isUsed = new HashMap<Integer, Boolean>();
		for(int i = 0; i < input.size(); i++) {
			isUsed.put(i, false);
		}
		int index = 0;
		for(String word : input) {
			if(isUsed.get(word)) {
				int n = getMatchingBeginning(word.charAt(word.length()-1), input);
				if(n >= 0) {	
					isUsed.put(n, true);	//If matching word is found, strike the word out of list
					isUsed.put(index, true);	//Also strike out the original word that was used to find the new word
				}
			}
			index++;
		}
		for(Integer i : isUsed.keySet()) {
			if(!isUsed.get(i)) {
				allUsed = false;
				System.out.println("The door cannot be opened.");
			}
		}
		if(allUsed) {
			System.out.println("Ordering is possible.");
		}
			
	}
	
	public static void main(String arg[]) {
		PlayOnWords pow = new PlayOnWords();
		List<String>input = new ArrayList<String>();
		input.add("acm");
		input.add("mouse");
		input.add("malform");
		pow.solve(input);
	}
}
