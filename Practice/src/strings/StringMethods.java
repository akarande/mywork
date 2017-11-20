package strings;

public class StringMethods {

	public int subString(String str, String subStr) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < subStr.length();) {
				if(subStr.charAt(j) == str.charAt(i+j)) {
					while(j < subStr.length() && subStr.charAt(j) == str.charAt(i+j)) {
						j++;
					}
				}
				if(j >= subStr.length()) {
					return i;
				} else {
					break;
				}
			}
		}
		return -1;
	}
	
	public int atoi(String s) {
		boolean negative = false;
		int ans = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i == 0 && s.charAt(i) == '-') {
				negative = true;
			} else {
				ans = ans*10 + (s.charAt(i) - '0');
			}
		}
		return ans = negative ? ans*(-1) : ans;
	}
	
	public static void main(String arg[]) {
		StringMethods sm = new StringMethods();
		//System.out.println(sm.subString("HelloWorld", "el"));
		System.out.println(sm.atoi("33"));
		System.out.println(sm.atoi("-452456920"));
		System.out.println(sm.atoi("+0"));
	}
}
