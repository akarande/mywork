package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * EG: input: [1,1,2]
 * output: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * EG: input: [1,2,3]
 * output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * @author akarande
 */
public class Permutations {

	List<List<Integer>> permute(int nums[]) {
		List<List<Integer>>result = new ArrayList<>();
		solve(nums, new ArrayList<>(), result);
		return result;
	}
	
	void solve(int[] nums, List<Integer>currList, List<List<Integer>> result) {
		if(currList.size() == nums.length) {
			result.add(new ArrayList<>(currList));
		} else {
			for(int i = 0; i < nums.length; i++) {
				if(currList.contains(nums[i])) continue;
				currList.add(nums[i]);
				solve(nums, currList, result);
				currList.remove(currList.size() - 1);
			}
		}
	}
	
	List<List<Integer>> permuteUnique(int nums[]) {
		List<List<Integer>>result = new ArrayList<>();
		Arrays.sort(nums);
		solve(nums, new ArrayList<>(), new boolean[nums.length], result);
		return result;
	}
	
	void solve(int[] nums, List<Integer> currList, boolean[] visited, List<List<Integer>> result) {
		if(currList.size() == nums.length) {
			result.add(new ArrayList<>(currList));
		} else {
			for(int i = 0; i < nums.length; i++) {
				if(visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
				currList.add(nums[i]);
				visited[i] = true;
				solve(nums, currList, visited, result);
				currList.remove(currList.size() - 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String arg[]) {
		int nums1[] = {1, 2, 3};
		int nums2[] = {1, 2, 2};
		Permutations p = new Permutations();
		p.permute(nums1).stream().forEach(e -> System.out.print(e + " "));
		System.out.println();
		p.permuteUnique(nums2).stream().forEach(e -> System.out.print(e + " "));
	}
}
