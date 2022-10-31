package com.ohyr.boj.step28.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(in.readLine());
		
		List<int[]>[] adj = new List[v+1];
		for(int i=0;i<=v;i++) {
			adj[i] = new ArrayList<int[]>();
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new int[] {b, c});
		}
		
		boolean[] visited = new boolean[v+1];
		
		int[] distance = new int[v+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[k] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] {k, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int a = cur[0];
			
			if(visited[a]) continue;
			visited[a] = true;
			
			for(int[] node : adj[a]) {
				if(visited[node[0]]) continue;
				distance[node[0]] = Math.min(distance[node[0]], distance[a] + node[1]);
				pq.offer(new int[] {node[0], distance[node[0]]});
			}
		}
		
		for(int i=1;i<=v;i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
