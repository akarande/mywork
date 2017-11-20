package general;

import java.util.Arrays;
/**
 * DFS simple implementation using adjacency graph
 * @author akarande
 *
 */
public class Dfs {

	boolean visited[];
	int g[][];
	
	void init() {
		 g = new int[][] {{0, 1, 0, 1, 0, 0, 0, 0, 1},
						  {1, 0, 0, 0, 0, 0, 0, 1, 0},
						  {0, 0, 0, 1, 0, 1, 0, 1, 0},
						  {1, 0, 1, 0, 1, 0, 0, 0, 0},
						  {0, 0, 0, 1, 0, 0, 0, 0, 1},
						  {0, 0, 1, 0, 0, 0, 1, 0, 0},
						  {0, 0, 0, 0, 0, 1, 0, 0, 0},
						  {0, 1, 1, 0, 0, 0, 0, 0, 0},
						  {1, 0, 0, 0, 1, 0, 0, 0, 0}
				};
		visited = new boolean[g.length];
		Arrays.fill(visited, false);
	}
	
	public void dfs(int i) {
		visited[i] = true;
		System.out.print(i + "\t");
		for(int j = 0; j < g.length; j++) {
			if(!visited[j] && g[i][j] == 1) {
				dfs(j);
			}
		}
	}
	
	public static void main(String arg[]) {
		Dfs dfs = new Dfs();
		dfs.init();
		dfs.dfs(0);
	}
}
