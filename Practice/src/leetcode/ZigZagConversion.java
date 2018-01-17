package leetcode;

import java.util.Arrays;

public class ZigZagConversion {

	public String convert(String s, int rows) {
        if(rows <= 1) return s;
        int n = s.length();
        String []arr = new String[rows];
        Arrays.fill(arr, "");
        int delta = 1;
        for(int i = 0, k = 0; i < n; i++) {
            arr[k] += s.charAt(i);
            if(k == 0) {
                delta = 1;
            }
            if(k == rows-1) {
                delta = -1;
            }
            k += delta;
        }
        String str = "";
        for(int i = 0; i < arr.length; i++) {
            str += arr[i];
        }
        return str;
    }
	
	public static void main(String arg[]) {
		ZigZagConversion zzc = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int rows = 3;
		System.out.println(zzc.convert(s, rows));
	}
}
