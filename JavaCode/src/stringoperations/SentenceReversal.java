package stringoperations;

import java.util.ArrayList;
import java.util.List;

public class SentenceReversal {

	public String reverse(String word) {
		StringBuilder sb = new StringBuilder();
		int length = word.length();
		for(int  i = 0; i < length; i++) {
			sb.append(word.charAt(length-1-i));
		}
		return sb.toString();
	}
	
	public List<String> parseWords(String sentence) {
		List<String>words = new ArrayList<String>();
		StringBuilder word;
		int length = sentence.length();
		for(int i = 0; i < length; i ++) {
			word = new StringBuilder();
			if(i == 0 && sentence.charAt(i) != ' ' || i > 0 && sentence.charAt(i) != ' ') {
				while(i < length && sentence.charAt(i) != ' ') {
					word.append(sentence.charAt(i++));
				}
			}
			words.add(reverse(word.toString()));
		}
		return words;
	}
	
	public int countWords(String sentence) {
		int count = 0, length = sentence.length();
		for(int i = 0; i < length; i++) {
			if(i == 0 && sentence.charAt(i) != ' ' || i > 0 && sentence.charAt(i) != ' ') {
				while(i < length && sentence.charAt(i) != ' ') {
					i++;
				}
				count++;
			}
		}
		return count;
	}
	
	public static void main(String arg[]) {
		String inputString = "Hello I am Tim and I am in Virginia";
		SentenceReversal sr = new SentenceReversal();
		inputString = sr.reverse(inputString);
		System.out.println(sr.parseWords(inputString));
		System.out.println("Total words in input String : " + sr.countWords(inputString));
	}
}
