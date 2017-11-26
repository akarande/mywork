package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphTraversals {

	int[][] graph;
	boolean visited[];
	List<List<Integer>>adjList;
	void init(int[][] g, List<List<Integer>>adj) {
		graph = g;
		adjList = adj;
		visited = new boolean[g.length];
		Arrays.fill(visited, false);
	}
	
	/**
	 * Simple depth first search
	 * @param current
	 */
	public void dfs(int current) {
		visited[current] = true;
		System.out.print(current + "\t");
		for(int i = 0; i < graph.length; i++) {
			if(!visited[i] && graph[current][i] == 1) {
				dfs(i);
			}
		}
	}
	
	/**
	 * BFS using adjacency matrix also has distance of neighbors
	 * from the starting node
	 */
	public void neighborDistance() {
		int n = graph.length;
		int distance[] = new int[n];
		Arrays.fill(distance, -1);
		distance[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < n; j++) {
				if(distance[j] == i-1) {
					for(int k = 0; k < n; k++) {
						if(graph[j][k] == 1 && distance[k] == -1) {
							distance[k] = i;
						}
					}
				}
			}
		}
		
		//Print distance of each neighbor
		System.out.println("Distance of neighbors from node 0");
		for(int i = 0; i < n; i++) {
			System.out.println("Node " + i + " is at distance " + distance[i] + " from node 0");
		}
	}
	
	/**
	 * Neighbor distance using BFS with adjacency list
	 */
	public void neighborDistance2() {
		int n = adjList.size();
		int distance[] = new int[n];
		Arrays.fill(distance, -1);
		distance[0] = 0;
		for(int i = 1; i <=n; i++) {
			for(int j = 0; j < n; j++) {
				if(distance[j] == i-1) {
					for(int neighbor : adjList.get(j)) {
						if(distance[neighbor] == -1) {
							distance[neighbor] = i;
						}
					}
				}
			}
		}
		
		//Print distance of each neighbor
		System.out.println("Distance of neighbors from node 0");
		for(int i = 0; i < n; i++) {
			System.out.println("Node " + i + " is at distance " + distance[i] + " from node 0");
		}
	}
	
	/**
	 * BFS traversal also printing the distance from node 'x', which is the start node
	 * with adjacency matrix
	 * @param current
	 */
	public void bfs(int current) {
		int n = graph.length;
		int[] distance = new int[n];
		Arrays.fill(distance, -1);
		distance[0] = 0;
		List<Integer>nodes = new ArrayList<>();
		nodes.add(current);
		for(int i = 0; i < nodes.size(); i++) {
			int curr = nodes.get(i);
			System.out.print(curr + "\t");
			for(int j = 0; j < n; j++) {
				if(graph[curr][j] == 1 && distance[j] == -1) {
					nodes.add(j);
					distance[j] = distance[curr] + 1;
				}
			}
		}
		System.out.println();
		//Print distance of each neighbor
		System.out.println("Distance of neighbors from node 0");
		for(int i = 0; i < n; i++) {
			System.out.println("Node " + i + " is at distance " + distance[i] + " from node 0");
		}
	}
	
	/**
	 * BFS traversal also printing the distance from node 'x', which is the start node
	 * with adjacency list
	 * @param start
	 */
	public void bfs2(int start) {
		int n = graph.length;
		int[] distance = new int[n];
		Arrays.fill(distance, -1);
		distance[0] = 0;
		List<Integer>queue = new ArrayList<>();
		queue.add(start);
		for(int i = 0; i < queue.size(); i++) {
			int curr = queue.get(i);
			System.out.print(curr + "\t");
			for(int neighbor : adjList.get(curr)) {
				if(distance[neighbor] == -1) {
					queue.add(neighbor);
					distance[neighbor] = distance[curr] + 1;
				}
			}
		}
		
		System.out.println();
		//Print distance of each neighbor
		System.out.println("Distance of neighbors from node 0");
		for(int i = 0; i < n; i++) {
			System.out.println("Node " + i + " is at distance " + distance[i] + " from node 0");
		}
	}
	
	public static void main(String arg[]) {
		int[][] g = {{0, 1, 0, 0, 0, 0, 1, 0, 0},
					 {1, 0, 1, 1, 0, 1, 0, 0, 0},
					 {0, 1, 0, 0, 0, 0, 0, 1, 1},
					 {0, 1, 0, 0, 1, 0, 0, 0, 0},
					 {0, 0, 0, 1, 0, 1, 0, 0, 0},
					 {0, 1, 0, 0, 1, 0, 0, 0, 0},
					 {1, 0, 0, 0, 0, 0, 0, 1, 0},
					 {0, 0, 1, 0, 0, 0, 1, 0, 0},
					 {0, 0, 1, 0, 0, 0, 0, 0, 0}};
		
		List<List<Integer>> adj = new ArrayList<>();
		adj.add(0, Arrays.asList(1, 6));
		adj.add(1, Arrays.asList(0, 2, 3, 5));
		adj.add(2, Arrays.asList(1, 8));
		adj.add(3, Arrays.asList(1, 4));
		adj.add(4, Arrays.asList(3, 5));
		adj.add(5, Arrays.asList(1, 4));
		adj.add(6, Arrays.asList(0, 7));
		adj.add(7, Arrays.asList(2, 6));
		adj.add(8, Arrays.asList(2));
		
		GraphTraversals gt = new GraphTraversals();
		gt.init(g, adj);
		//gt.dfs(0);
		gt.bfs2(0);
		//gt.neighborDistance();
		//gt.neighborDistance2();
		
	}
}
