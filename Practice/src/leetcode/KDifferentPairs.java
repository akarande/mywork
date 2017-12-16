package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KDifferentPairs {

	public int findPairs(int[] nums, int k) {
        List<List<Integer>>used = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
            	List<Integer>t = new ArrayList<>();
            	t.add(nums[i]); t.add(nums[j]);
                if(Math.abs(nums[i]-nums[j]) == k && !contains(used,  t)) {
                    count++;
                    used.add(t);
                }
            }
        }
        return count;
    }
    
    boolean contains(List<List<Integer>>arr, List<Integer>curr) {
        for(List<Integer> x : arr) {
            Collections.sort(x);
            Collections.sort(curr);
            int i = 0;
            while(i < x.size()) {
                if(x.get(0).intValue() == curr.get(0).intValue() 
                		&& x.get(1).intValue() == curr.get(1).intValue()) return true;
            }
        }
        return false;
    }
    
    public static void main(String arg[]) {
    	KDifferentPairs kdp = new KDifferentPairs();
    	int[] nums = {1, 2, 3, 4, 5};
    	int k = 1;
    	System.out.println(kdp.findPairs(nums, k));
    }
}
