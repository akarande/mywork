package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>result = new ArrayList<>();
        solve(n, 1, k, new ArrayList<>(), result);
        return result;
    }
    
    void solve(int n, int pos, int limit, List<Integer> currList, List<List<Integer>>result) {
        if(currList.size() == limit) {
            result.add(new ArrayList<>(currList));
        } else {
            for(int i = pos; i <= n; i++) {
                if(currList.contains(i)) continue;
                currList.add(i);
                solve(n, i, limit, currList, result);
                currList.remove(currList.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> coinCombination(int[] nums, int target) {
    	List<List<Integer>>result = new ArrayList<>();
    	solve2(nums, target, 0, new ArrayList<>(), result);
    	return result;
    }
    
    void solve2(int[] nums, int target, int pos, List<Integer> currList, List<List<Integer>> result) {
    	if(target < 0) return;
    	if(target == 0) {
    		result.add(new ArrayList<>(currList));
    	} else {
	    	for(int i = pos; i < nums.length; i++) {
	    		currList.add(nums[i]);
	    		solve2(nums, target-nums[i], i, currList, result);
	    		currList.remove(currList.size()-1);
	    	}
    	}
    }
    
    public static void main(String arg[]) {
    	Combinations cb = new Combinations();
    	int n = 4, k = 2;
    	//cb.combine(n, k).stream().forEach(e -> System.out.print(e.toString() + " "));
    	int nums[] = {1,2,5};
    	int target = 5;
    	List<List<Integer>>lst = cb.coinCombination(nums, target);
    	for(List<Integer>l : lst) {
    		System.out.println(l);
    	}
    }
}
