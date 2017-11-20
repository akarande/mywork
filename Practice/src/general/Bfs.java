package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bfs {
	int[][] g;
	int[] distance;
	List<List<Integer>>adj;
	
	int n;
	
	Bfs(int[][] g, List<List<Integer>> adj) {
		this.g = g;
		this.n = adj.size();
		this.distance = new int[n];
		this.adj = adj;
	}
	
	void calculate() {
		for (int i = 0;i < n;i++) {
			this.distance[i] = -1;
		}
		distance[0] = 0;
		
		//Distance Loop all neighbors at distance i
		for (int i = 1;i <= n;i++) {
			//Neighbor loop for each jth node find the neigbor of distance i
			for (int j = 0;j < n;j++) {
				if (distance[j] == i - 1) {
					//Each neighbor of j at distance i-1 that are not visited before
					for (int k = 0;k < n;k++) {
						if (g[j][k] == 1 && distance[k] == -1) {
							distance[k] = i;
						}
					}
				}
			}
		}
	}

	void calculate2() {
		for (int i = 0;i < n;i++) {
			this.distance[i] = -1;
		}
		
		List<Integer> queue = new ArrayList<Integer>();
		distance[0] = 0;
		queue.add(0);
		for (int i = 0;i < queue.size();i++) {
			int cur = queue.get(i);
			for (int j = 0;j < n;j++) {
				if (g[cur][j] == 1 && distance[j] == -1) {
					distance[j] = 1 + distance[cur];
					queue.add(j);
				}
			}
		}
	}

	// With adjacency list
	void calculate3() {
		for (int i = 0; i < adj.size(); i++) {
			this.distance[i] = -1;
		}
		
		distance[0] = 0;
		int n = adj.size();
		List<Integer> currList = new ArrayList<>();
		List<Integer>queue = new ArrayList<>();
		queue.addAll(adj.get(0));
		for(int i = 0; i < n; i++) {
			currList.addAll(queue);
			queue.clear();
			for(int j = 0; j < currList.size(); j++) {
				int val = currList.get(j);
				if(distance[val] == -1) {
					distance[val] = 1 + distance[i];
					queue.addAll(adj.get(val));
				}
			}
			currList.clear();
		}
	}
	
	
	// With adjacency list
		void calculate4() {
			for (int i = 0; i < adj.size(); i++) {
				this.distance[i] = -1;
			}
			distance[0] = 0;
			int n = adj.size();
			List<Integer>queue = new ArrayList<>();
			queue.addAll(adj.get(0));
			int k = 0;
			//Distance loop for all neighbors at distance i
			for(int i = 0; i < n; i++) {
				int q = queue.size();
				for(int j = i + k; j < q; j++) {
					int val = queue.get(j);
					if(distance[val] == -1) {
						distance[val] = 1 + distance[i];
						queue.addAll(adj.get(val));
						k++;
					}
				}
			}
		}
	
	
	public static void main(String[] args) {
		int[][] g = new int[][]{
			{0, 1, 0, 0, 0, 1},
			{1, 0, 1, 1, 0, 0},
			{0, 1, 0, 1, 0, 0},
			{0, 1, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 1},
			{0, 1, 0, 0, 1, 0},
		};
		
		List<List<Integer>> arr = new ArrayList<>();
				arr.add(Arrays.asList(1, 5));
				arr.add(Arrays.asList(0, 2, 3));
				arr.add(Arrays.asList(1, 3));
				arr.add(Arrays.asList(1, 2, 4));
				arr.add(Arrays.asList(3, 5));
				arr.add(Arrays.asList(1, 4));
		
		Bfs bfs = new Bfs(g, arr);
		bfs.calculate4();
		for (int i = 0;i < g.length;i++) {
			System.out.println(bfs.distance[i]);
		}
	}
}
