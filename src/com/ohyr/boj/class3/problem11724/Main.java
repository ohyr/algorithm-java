package com.ohyr.boj.class3.problem11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[n][n];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		
		int[] cc = new int[n];
		for(int i=0;i<n;i++) {
			cc[i] = i;
		}
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(graph[i][j] == 1) {
					if(cc[i] < cc[j]) {
						cc[j] = cc[i];
					}else if(cc[i] > cc[j]) {
						cc[i] = cc[j];
					}
				}
			}
		}
		
		boolean[] checked = new boolean[n];
		for(int i=0;i<n;i++) {
			checked[cc[i]] = true;
		}
		
		int answer = 0;
		for(int i=0;i<n;i++) {
			if(checked[i]) answer++;
		}
		
		System.out.println(answer);
	}

}
