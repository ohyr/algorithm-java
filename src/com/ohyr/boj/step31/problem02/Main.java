package com.ohyr.boj.step31.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int Answer;
	public static int End;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int v = Integer.parseInt(in.readLine());
		
		ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
		for(int i=0;i<v;i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i=0;i<v;i++) {
			st = new StringTokenizer(in.readLine());
			int cur = Integer.parseInt(st.nextToken())-1;
			while(true) {
				int a = Integer.parseInt(st.nextToken())-1;
				if(a == -2) break;
				int b = Integer.parseInt(st.nextToken());
				
				tree.get(cur).add(new int[] {a, b});
			}
		}
		
		Answer = 0;
		End = 0;
		visited = new boolean[v];
		visited[0] = true;
		dfs(0, 0, tree);
		
		Answer = 0;
		visited = new boolean[v];
		visited[End] = true;
		dfs(End, 0, tree);
		
		System.out.println(Answer);
	}

	private static void dfs(int vertex, int sum, ArrayList<ArrayList<int[]>> tree) {
		if(Answer < sum) {
			Answer = sum;
			End = vertex;
		}
		
		for(int[] node: tree.get(vertex)) {
			if(visited[node[0]]) continue;
			visited[node[0]] = true;
			dfs(node[0], sum+node[1], tree);
		}
	}

}
