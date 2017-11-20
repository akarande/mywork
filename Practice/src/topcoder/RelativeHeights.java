package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RelativeHeights {
	public int CountWays(int[] h) {
		Set<List<Integer>> total = new HashSet<>();
		for(int  i = 0; i < h.length; i++) {
			int[] curr = getAllBut(i, h);
			int temp[] = curr;
			Arrays.sort(temp);
			List<Integer> profile = new ArrayList<Integer>();
			profile = getWeightFor(curr, temp);
			System.out.println(profile);
			total.add(profile);
		}
			return total.size();
	}
	
	public List<Integer> getWeightFor(int[] curr, int[] w) {
		List<Integer>ls = new ArrayList<Integer>();
		for(int i = 0; i < curr.length; i++) {
			for(int j = 0; j < w.length; j++) {
				if(curr[i] == w[j]) {
					ls.add(j);
				}
			}
		}
		return ls;
	}
	
	public int[] getAllBut(int ind, int[] arr) {
		int i = 0, j = 0;
		int ans[] = new int[arr.length-1];
		for(i = 0; i < arr.length; i++) {
			if(i == ind) {
				continue;
			} else {
				ans[j++] = arr[i];
			}
		}
		return ans;
	}
	
	public static void main(String arg[]) {
		RelativeHeights rh = new RelativeHeights();
		int[] h ={6,2,352,43,5,44};//{1,3,6,10,15,21};
		System.out.println(rh.CountWays(h));
	}

}