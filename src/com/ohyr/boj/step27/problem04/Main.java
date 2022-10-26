package com.ohyr.boj.step27.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<=n;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		for(int i=0;i<=n;i++) {
			Collections.sort(adj.get(i), (a, b) -> b - a);
		}
		
		int cnt = 1;
		int[] visited = new int[n+1];
		visited[r] = cnt++;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(r);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : adj.get(cur)) {
				if(visited[next] != 0) continue;
				visited[next] = cnt++;
				q.offer(next);
			}
		}
		
		for(int i=1;i<=n;i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
