package leetcode;

public class MaximumSwap {

	public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();
        int n = c.length;
        int[] dpIndex = new int[n];
        int maxIndex = n-1;
        for(int i = n-1; i >= 0; i--) {
            if(c[i] > c[maxIndex]) maxIndex = i;
            dpIndex[i] = maxIndex;
        }
        for(int i = 0; i < n; i++) {
            if(c[dpIndex[i]] != c[i]) {
                char t = c[i];
                c[i] = c[dpIndex[i]];
                c[dpIndex[i]] = t;
                break;
            }
        }
        return Integer.valueOf(new String(c)).intValue();
    }
	
	public static void main(String arg[]) {
		int num = 2736;
		MaximumSwap ms = new MaximumSwap();
		System.out.println(ms.maximumSwap(num));
	}
}
