package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestRange {

	public int[] smallestRange(List<List<Integer>> nums) {
        int pointers[] = new int[nums.size()];
        int range = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = nums.get(0).get(0);
        int minPtr = 0;
        int a1 = 0, a2 = 0;
        for(int i = 0; i < nums.size(); i++) {
            int j = 0;  //Pointer to beginning of each list
            if(pointers[j] > nums.get(j).size()) break;
            while(j < nums.size() && pointers[j]  < nums.get(j).size()) {
                int current = nums.get(j).get(pointers[j]);
                if(min > current) {
                    min = current;
                    minPtr = j;
                }
                max = Math.max(current, max);
                if(range > (max - current)) {
                    range = max - min;
                    a1 = min;
                    a2 = max;
                }
                j++;
            }
            pointers[minPtr]++;
        }
        int[] ans = {a1, a2};
        return ans;
    }
	
	public static void main(String arg[]) {
		SmallestRange sr = new SmallestRange();
		List<List<Integer>>nums = new ArrayList<>();
		nums.add(Arrays.asList(4,10,15,24,26)); 
		nums.add(Arrays.asList(0,9,12,20));
		nums.add(Arrays.asList(5,18,22,30));
		int a[] = sr.smallestRange(nums);
		System.out.println("A[0]=" + a[0] + ", A[1]=" + a[1]);
	}
}
