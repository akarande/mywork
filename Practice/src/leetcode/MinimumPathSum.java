package leetcode;

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = grid[m-1][n-1];
        /*3 options if you reached the ith boundary use everything upto last column
            else if you reached jth boundary use everything upto last row
            else take minimum of down and left
        */
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i != 0 && j == 0) {
                    grid[i][j] += grid[i-1][j];
                } else if(i == 0 && j != 0) {
                    grid[i][j] += grid[i][j-1];
                } else if(i == 0 && j == 0) {
                    grid[i][j] = grid[i][j]; //Do nothing
                } else {
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
	
	public static void main(String arg[]) {
		int[][] g = {{1,3,1},
					 {1,5,1},
					 {4,2,1}};
		MinimumPathSum mps = new MinimumPathSum();
		System.out.println(mps.minPathSum(g));
	}
}
