package leetcode;

public class HammingDistance {

	public int totalHammingDistance(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int k = i; k < nums.length; k++) {
                if(i == k) continue;
                int t = hamming(nums[i], nums[k]);
                System.out.println("XOR " + nums[i] + " and " + nums[k] + " is " + t);
                total += t;
            }
        }
        return total;
    }
    
    int hamming(int a, int b) {
        int count = 0;
        int p, q;
        while(a > 0 && b > 0) {
            p = a&1;
            q = b&1;
            if(p != q) count++;
            a = a>>1;
            b = b>>1;
        }
        while(a > 0) {
            p = a&1;
            if(p == 1) count++;
            a = a>>1;
            
        }
         while(b > 0) {
             q = b&1;
             if(q == 1) count++;
             b = b>>1;
         }
        return count;
    }
    
    public static void main(String arg[]) {
    	HammingDistance hd = new HammingDistance();
    	int nums[] = {4, 14, 2};
    	System.out.println(hd.totalHammingDistance(nums));
    }
}
