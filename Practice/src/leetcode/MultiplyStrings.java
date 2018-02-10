package leetcode;

import java.util.Arrays;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "0";
        int carry = 0;
        int k = 0;
        int carrySum = 0;
        char[] n1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] n2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int ans[] = new int[n1.length + n2.length + 1];        
        Arrays.fill(ans, 0);
        for(int i = 0; i < n2.length; i++) {
            k = i;
            carry = 0;
            carrySum = 0;
            for(int j = 0; j < n1.length; j++, k++) {
                int product = (n1[j]-'0')*(n2[i]-'0') + carry;
                carry = product / 10;
                ans[k] += product % 10 + carrySum;
                carrySum = ans[k]/10;
                ans[k] = ans[k]%10;
            }
            if(carry > 0) ans[k] = carry;
            if(carrySum > 0) ans[k] += carrySum;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= k; i++) {
            sb.append((char)(ans[i] + '0'));
        }
        String ret = sb.reverse().toString();
        while(ret.length() > 1 && ret.charAt(0) == '0') ret = ret.substring(1);
        return ret;
    }
	
	//Method 2
    public String multiply2(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "0";
        char[] n1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] n2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int ans[] = new int[n1.length + n2.length];
        String ret = null;
        for(int i = 0; i < n1.length; i++) {
            for(int j = 0; j < n2.length; j++) {
                ans[i + j] += (n1[i]- '0') * (n2[j] - '0');
                ans[i + j + 1] += ans[i + j] / 10;
                ans[i + j] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ans.length; i++) {sb.append((char)(ans[i] + '0'));}
        ret = sb.reverse().toString();
        while(ret.length() > 1 && ret.charAt(0) == '0') ret = ret.substring(1);
        return ret;
    }
	
	public static void main(String arg[]) {
		MultiplyStrings ms = new MultiplyStrings();
		String num1 = "9", num2="9";
		System.out.println(ms.multiply(num1, num2));
	}
}
