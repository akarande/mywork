package problems;

public class CountWords {

	public int count(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i == 0 && s.charAt(i) != ' ' || i > 0 && s.charAt(i) != ' ' && s.charAt(i-1) == ' ') {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String arg[]) {
		CountWords cw = new CountWords();
		System.out.println(cw.count("Hello my       name is Jack and she is   Allie."));
	}
}
