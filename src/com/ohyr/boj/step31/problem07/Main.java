package com.ohyr.boj.step31.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int nodeCnt;
	static int edgeCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int tc = 1;
		while(true) {			
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) {
				break;
			}
			
			List[] adj = new LinkedList[n + 1];
			for(int i=0;i<=n;i++) {
				adj[i] = new LinkedList<Integer>();
			}
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[a].add(b);
				adj[b].add(a);
			}
			
			int treeNum = 0;
			boolean[] visited = new boolean[n + 1];
			
			for(int i=1;i<=n;i++) {
				if(visited[i]) continue;
				
				nodeCnt = 0;
				edgeCnt = 0;
				dfs(i, n, adj, visited);
				
				if(edgeCnt / 2 == nodeCnt - 1) {
					treeNum++;
				}
			}
			
			sb.append("Case ").append(tc++).append(": ");
			
			if(treeNum == 0) {
				sb.append("No trees.");
			}else if(treeNum == 1) {
				sb.append("There is one tree.");
			}else {
				sb.append("A forest of ").append(treeNum).append(" trees.");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int cur, int n, List[] adj, boolean[] visited) {
		nodeCnt++;
		edgeCnt += adj[cur].size();
		visited[cur] = true;
		
		List<Integer> list = adj[cur];
		for(int next : list) {
			if(visited[next]) continue;
			dfs(next, n, adj, visited);
		}
	}

}
