package com.ohyr.boj.class4.problem1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == j) continue;
				map[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int price = Integer.parseInt(st.nextToken());
			
			map[a][b] = Math.min(map[a][b], price);
		}
		
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[start] = 0;
		
		while(true) {
			int cur = -1;
			int min = Integer.MAX_VALUE;
			
			for(int i=0;i<n;i++) {
				if(!visited[i] && distance[i] < min) {
					cur = i;
					min = distance[i];
				}
			}
			
			if(cur == end) break;
			
			visited[cur] = true;
			
			for(int i=0;i<n;i++) {
				if(!visited[i] && distance[i] > min + map[cur][i]) {
					distance[i] = min + map[cur][i];
				}
			}
		}
		
		System.out.println(distance[end]);
	}

}
