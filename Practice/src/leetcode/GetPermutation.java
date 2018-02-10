package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
 * @author akarande
 *
 */

public class GetPermutation {

	public String getPermutation(int n, int k) {
        int fact[] = new int[n+1];
        fact[0] = 1;
        //Calculate the factorial
        for(int i = 1; i <= n; i++) {
            fact[i] = i*fact[i-1];
        }
        //Make the list from 1 to n;
        List<Integer>currList = new ArrayList<>();
        for(int i = 1; i <= n; i++) currList.add(i);
        
        //Now form the kth permutation
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            int currIndex = (k-1)/fact[n-i];
            sb.append((char)(currList.get(currIndex) + '0'));
            currList.remove(currIndex);
            k = k - currIndex*fact[n-i];
        }
        return sb.toString();
    }
	
	public static void main(String arg[]) {
		GetPermutation gp = new GetPermutation();
		int n = 4, k = 14;
		System.out.println(gp.getPermutation(n, k));
	}
}
