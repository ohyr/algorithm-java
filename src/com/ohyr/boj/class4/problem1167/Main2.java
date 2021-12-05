package com.ohyr.boj.class4.problem1167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

	public static int Answer;
	
	private static void dfs(int vertex, int sum, boolean[] isRoot, boolean[] visited, ArrayList<ArrayList<int[]>> tree, int start) {
		if(vertex != start && isRoot[vertex]) {
			Answer = Math.max(Answer, sum);
			return;
		}
		
		for(int[] node: tree.get(vertex)) {
			int v = node[0];
			int w = node[1];
			
			if(visited[v]) continue;
			visited[v] = true;
			
			dfs(v, sum+w, isRoot, visited, tree, start);
			
			visited[v] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int v = Integer.parseInt(in.readLine());
		
		ArrayList<ArrayList<int[]>> tree = new ArrayList<ArrayList<int[]>>();
		for(int i=0;i<=v;i++) {
			tree.add(new ArrayList<int[]>());
		}
		
		boolean[] isRoot = new boolean[v+1];
		
		for(int i=0;i<v;i++) {
			st = new StringTokenizer(in.readLine());
			int cur = Integer.parseInt(st.nextToken());
			int cnt = 0;
			while(true) {
				int a = Integer.parseInt(st.nextToken());
				if(a == -1) {
					if(cnt == 1) {
						isRoot[cur] = true;
					}
					break;
				}
				int b = Integer.parseInt(st.nextToken());
				cnt++;
				
				tree.get(cur).add(new int[] {a, b});
			}
		}
		
		Answer = 0;
		
		boolean[] visited = new boolean[v+1];
		
		for(int i=1;i<=v;i++) {
			if(isRoot[i]) {
				visited[i] = true;
				dfs(i, 0, isRoot, visited, tree, i);
			}
		}
		
		System.out.println(Answer);
	}

}
