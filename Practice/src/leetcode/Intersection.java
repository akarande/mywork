package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

	public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        
        List<Integer>ans = new ArrayList<>();
        for(int j = 0, k = 0; j < m && k < n;) {
            if(nums1[j] == nums2[k]) {
                ans.add(nums1[j]);
                j++;
                k++;
            } else if(nums1[j] < nums2[k]) {
                j++;
            } else {
                k++;
            }
        }
        int arr[] = new int[ans.size()];
        int i = 0;
        for(Integer x : ans) {
            arr[i++] = x.intValue();
        }
        return arr;
    }
	
	public static void main(String arg[]) {
		int arr1[] = {1,2,2,1};
		int arr2[] = {2,2};
		Intersection is = new Intersection();
		for(int x : is.intersection(arr1, arr2)) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
