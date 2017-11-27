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
    
    public static void main(String arg[]) {
    	Combinations cb = new Combinations();
    	int n = 4, k = 2;
    	cb.combine(n, k).stream().forEach(e -> System.out.print(e.toString() + " "));
    }
}
