package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        if(amount == 0) return 0;
        return solve(coins, amount);
    }
    
    int solve(int[] coins, int amount) {
        Queue<Integer>queue = new LinkedList<>();
        boolean visited[] = new boolean[amount+1];
        Arrays.fill(visited, false);
        visited[amount] = true;
        int level = 1;
        
        queue.add(amount);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int k = 0; k < n; k++) {
                int currValue = queue.remove();
                
                for(int i = 0; i < coins.length; i++) {
                    int currSum = currValue - coins[i];
                    if(currSum == 0) return level;
                    else if(currSum > 0 && !visited[currSum]) {
                        queue.add(currSum);
                        visited[currSum] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    public static void main(String arg[]) {
    	CoinChange cc = new CoinChange();
    	int coins[] = {1,2,5};
    	int amount = 11;
    	System.out.println(cc.coinChange(coins, amount));
    }

}
