package problems;

public class ReverseSentence {
	
	public String reverse(String s) {
		StringBuilder ans = new StringBuilder();
		for(int i = s.length()-1; i >=0 ; i--) {
			ans.append(s.charAt(i));
		}
		return ans.toString();
	}
	
	public String reverseSentence(String sentence) {
		int n = sentence.length();
		sentence = reverse(sentence);
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < n; i++) {
			if(i == 0 && sentence.charAt(i) != ' ' 
					|| i > 0 && sentence.charAt(i) != ' ' && sentence.charAt(i-1) == ' ') {
				int  k = i;
				StringBuilder sb = new StringBuilder();
				while(k < n && sentence.charAt(k) != ' ') {
					sb.append(sentence.charAt(k++));
				}
				ans.append(reverse(sb.toString() + " "));
				i = k;
			} else {
				ans.append(sentence.charAt(i));
			}
		}
		return ans.toString();
	}
	
	public static void main(String arg[]) {
		ReverseSentence rs = new ReverseSentence();
		System.out.println(rs.reverseSentence("Hello, my name is Jack and she is Allie."));
	}

}
