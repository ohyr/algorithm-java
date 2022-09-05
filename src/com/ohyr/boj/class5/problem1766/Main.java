package com.ohyr.boj.class5.problem1766;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[n+1];
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1;i<=n;i++) {
			if(indegree[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			sb.append(cur).append(" ");
			
			for(int i=0;i<adj[cur].size();i++) {
				int next = adj[cur].get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					pq.add(next);
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
