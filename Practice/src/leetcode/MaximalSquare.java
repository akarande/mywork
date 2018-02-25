package leetcode;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int dp[][] = new int[m + 1][n + 1];
        int result = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result*result;
    }
	
	public static void main(String arg[]) {
		MaximalSquare ms = new MaximalSquare();
		char[][] matrix = {{'1', '0', '1', '0', '0'},
						   {'1', '0', '1', '1', '1'}, 
						   {'1', '1', '1', '1', '1'},
						   {'1', '0', '0', '1', '0'}};
		System.out.println(ms.maximalSquare(matrix));
	}
}
