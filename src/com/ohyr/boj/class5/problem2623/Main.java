package com.ohyr.boj.class5.problem2623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
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
		
		int[] indegree = new int[n+1];
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int singerNum = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int j=0;j<singerNum - 1;j++) {
				int cur = Integer.parseInt(st.nextToken());
				
				adj[prev].add(cur);
				indegree[cur]++;
				
				prev = cur;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(indegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			sb.append(cur).append("\n");
			
			for(int i=0;i<adj[cur].size();i++) {
				int next = adj[cur].get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(indegree[i] != 0) {
				sb = new StringBuilder();
				sb.append(0);
			}
		}
		
		System.out.println(sb.toString());
	}

}
