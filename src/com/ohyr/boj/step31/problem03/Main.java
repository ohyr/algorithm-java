package com.ohyr.boj.step31.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int Max;
	public static int endNode;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
		for(int i=0;i<n;i++) {
			tree.add(new ArrayList<int[]>());
		}
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			tree.get(p).add(new int[] {c, w});
			tree.get(c).add(new int[] {p, w});
		}
		
		Max = 0;
		endNode = 0;
		visited = new boolean[n];
		visited[0] = true;
		dfs(0, 0, tree);
		
		Max = 0;
		visited = new boolean[n];
		visited[endNode] = true;
		dfs(endNode, 0, tree);
		
		System.out.println(Max);
	}
	
	private static void dfs(int cur, int sum, ArrayList<ArrayList<int[]>> tree) {
		if(Max < sum) {
			Max = sum;
			endNode = cur;
		}
		
		for(int i=0;i<tree.get(cur).size();i++) {
			int next = tree.get(cur).get(i)[0];
			int weight = tree.get(cur).get(i)[1];
			
			if(visited[next]) continue;
			visited[next] = true;
			
			dfs(next, sum + weight, tree);
		}
	}
	
}
