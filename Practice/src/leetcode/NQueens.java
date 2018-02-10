package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	
	class Position {
		int row, col;
		public Position(int r, int c) {
			row = r;
			col = c;
		}
	}
	
	public List<List<String>> nQueens(int n) {
		List<List<String>>result = new ArrayList<>();
		solve(0, n, new Position[n], result);
		return result;
	}
	
	public void solve(int curr, int total, Position[] position, List<List<String>>result) {
		if(total == curr) {
			formBoard(position, result, total);
		}
		for(int i = 0; i < total; i++) {
			boolean isSafe = true;
			for(int j = 0; j < curr; j++) {
				if(position[i].col == j || position[i].col - position[i].row == j-i
						|| position[i].col + position[i].row == j + i) {
					isSafe = false;
				}
			}
			if(isSafe) {
				position[curr] = new Position(i, curr);
				solve(curr+1, total, position, result);
			}
		}
	}
	
	void formBoard(Position[] position, List<List<String>> result, int total) {
		List<String>currResult = new ArrayList<>();
		for(Position p : position) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < total; j++) {
				if(p.col == j) sb.append("Q");
				else sb.append(".");
			}
			currResult.add(sb.toString());
		}
		result.add(currResult);
	}

}
