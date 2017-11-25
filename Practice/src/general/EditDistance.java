package general;

public class EditDistance {

	
	int editDistance(String s1, String s2) {
		if(s1 == null || s1.length() == 0) return s2.length();
		if(s2 == null || s2.length() == 0) return s1.length();
		else if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)) 
			return editDistance(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1));
		else {
			int d1 = editDistance(s1, s2.substring(0, s2.length()-1));	//Remove
			int d2 = editDistance(s1.substring(0, s1.length()-1), s2);	//Insert
			int d3 = editDistance(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1));	//Replace
			return 1 + Math.min(d1, Math.min(d2, d3));
		}
	}
	
	public static void main(String arg[]) {
		String s1 = "abbcd";
		String s2 = "adccdd";
		EditDistance ed = new EditDistance();
		System.out.println(ed.editDistance(s1, s2));
	}
}
