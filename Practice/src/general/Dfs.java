package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * DFS simple implementation using adjacency graph
 * @author akarande
 *
 */
public class Dfs {

	boolean visited[];
	int g[][];
	List<List<Integer>>adj;
	
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
		adj = new ArrayList<>();
		for(int i = 0; i < g.length; i++) {
			List<Integer> temp = new ArrayList<>();
			for(int j = 0; j < g[i].length; j++) {
				if(g[i][j] == 1) {
					temp.add(j);
				}
			}
			adj.add(i, new ArrayList<>(temp));
		}
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
	
	//With Adjacency List
	public void dfs2(int i) {
		visited[i] = true;
		System.out.print(i + "\t");
		for(int j = 0; j < adj.get(i).size(); j++) {
			int next = adj.get(i).get(j);
			if(!visited[next]) {
				dfs2(next);
			}
		}
	}
	
	public static void main(String arg[]) {
		Dfs dfs = new Dfs();
		dfs.init();
		dfs.dfs(0);
		System.out.println();
		Arrays.fill(dfs.visited, false);
		dfs.dfs2(0);
	}
}
