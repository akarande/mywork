package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * EG: input: given candidate set [2, 3, 6, 7] and target 7
 * output: [ [7], [2, 2, 3] ]
 * 
 * EG: input: given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8
 * output: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 * @author akarande
 */

public class CombinationSum {

	public List<List<Integer>>combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		solve(nums, target, 0, new ArrayList<>(), result);
		return result;
	}
	
	void solve(int[] nums, int remains, int pos, List<Integer>currList, List<List<Integer>>result) {
		if(remains < 0) return;
		if(remains == 0) {
			result.add(new ArrayList<>(currList));
		} else {
			for(int i = pos; i < nums.length; i++) {
				currList.add(nums[i]);
				solve(nums, remains - nums[i], i, currList, result);
				currList.remove(currList.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(candidates);
        solve2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    void solve2(int arr[], int remains, int pos, List<Integer> currList, List<List<Integer>> result) {
        if(remains < 0) return;
        if(remains == 0) {
            result.add(new ArrayList<>(currList));
        } else {
            for(int i = pos; i < arr.length; i++) {
                if(i > pos && arr[i] == arr[i-1]) continue;
                currList.add(arr[i]);
                solve2(arr, remains - arr[i], i+1, currList, result);
                currList.remove(currList.size() - 1);
            }
        }   
    }
	
	public static void main(String arg[]) {
		CombinationSum cs = new CombinationSum();
		int nums[] = {2, 3, 6, 7};
		int nums2[] = {10, 1, 2, 7, 6, 1, 5};
		int target = 7;
		int target2 = 8;
		cs.combinationSum(nums, target).stream().forEach(e -> System.out.print(e.toString() + " "));
		System.out.println();
		cs.combinationSum2(nums2, target2).stream().forEach(e -> System.out.print(e.toString() + " "));
	}
}
