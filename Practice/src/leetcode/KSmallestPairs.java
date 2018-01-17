package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSmallestPairs {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]>result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return result;
        List<int[]> pairs = new ArrayList<>();
        //Cartesian product
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                int a[] = new int[2];
                a[0] = nums1[i];
                a[1] = nums2[j];
                pairs.add(a);
            }
        }
        
        Collections.sort(pairs, (a, b) -> ((a[0] + a[1]) - (b[0] + b[1])));
        int toIndex = Math.min(pairs.size(), k);
        return pairs.subList(0, toIndex);
    }
	
	public static void main(String arg[]) {
		KSmallestPairs kmp = new KSmallestPairs();
		int[] nums1 = {1,2};
		int[] nums2 = {3};
		int k = 3;
		List<int[]> lst = kmp.kSmallestPairs(nums1, nums2, k);
		for(int[] x : lst) {
			System.out.println("[" + x[0] + ", " + x[1] + "]");
		}
	}
}
