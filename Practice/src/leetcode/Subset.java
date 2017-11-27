package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, 
 * nums, return all possible subsets (the power set).
 * EG: input: [1,2,2]
 * output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * EG: input: [1,2,3]
 * output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * @author akarande
 *
 */
public class Subset {

	public List<List<Integer>> calculateSubset(int[] nums) {
		List<List<Integer>>result = new ArrayList<>();
		solve(nums, 0, new ArrayList<>(), result);
		return result;
	}
	
	void solve(int[] nums, int pos, List<Integer> currList, List<List<Integer>> result) {
		result.add(new ArrayList<>(currList));
		for(int i = pos; i < nums.length; i++) {
			currList.add(nums[i]);
			solve(nums, i+1, currList, result);
			currList.remove(currList.size()-1);
		}
	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(nums);	//Sort the array so same elements are together
        solve2(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    void solve2(int nums[], int pos, List<Integer> currList, List<List<Integer>> result) {
        result.add(new ArrayList<>(currList));
        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;	//This won't work unless the array is sorted
            currList.add(nums[i]);
            solve2(nums, i+1, currList, result);
            currList.remove(currList.size()-1);
        }
    }
	
	public static void main(String arg[]) {
		Subset ss = new Subset();
		int[] nums = {1, 2, 2};
		//ss.calculateSubset(nums).stream().forEach(e -> System.out.print(e.toString() + " "));
		ss.subsetsWithDup(nums).stream().forEach(e -> System.out.print(e.toString() + " "));
	}
}
