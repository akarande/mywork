package leetcode;

public class ValidNumber {

	/**
	 * We start with trimming.
	 * If we see [0-9] we reset the number flags.
	 * We can only see . if we didn't see e or ..
	 * We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
	 * We can only see + and - in the beginning and after an e
	 * any other character break the validation.
	 * @param s
	 * @return
	 */
	public boolean isNumber(String s) {
        s = s.trim();
        if(s == null || s.length() == 0) return false;
        char arr[] = s.toCharArray();
        boolean isNum = false;
        boolean isSign = false;
        boolean isDot = false;
        boolean isExpo = false;
        boolean isNumAfterExpo = true;
        for(int i = 0; i < arr.length; i++) {
            //We got a regular number
            if(arr[i] >= '0' && arr[i] <= '9') {
                isNum = true;
                isNumAfterExpo = true;
            } else if(arr[i] == '+' || arr[i] == '-') {
                if(!isNum && !isSign && !isDot && !isExpo || i > 0 && arr[i-1] == 'e') isSign = true;
                else return false;
            } else if(arr[i] == '.') {
                if(!isExpo && !isDot /*&& i+1 < arr.length*/) isDot = true;
                else return false;
            } else if(arr[i] == 'e') {
                if(isNum && !isExpo) {
                    isExpo = true;
                    isNumAfterExpo = false;
                } else return false;
            } else {
                return false;
            }
        }
        return isNum && isNumAfterExpo;
    }
	
	public static void main(String arg[]) {
		ValidNumber vn = new ValidNumber();
		String s = " 002005e+64";
		System.out.println(vn.isNumber(s));
	}
}
