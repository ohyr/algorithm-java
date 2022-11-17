package com.ohyr.boj.step30.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = Math.min(map[a][b], c);
		}
		
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE / 2);
				
		distance[start] = 0;
		
		int[] beforeCity = new int[n];
		Arrays.fill(beforeCity, -1);
		
		while(true) {
			int cur = -1;
			int min = Integer.MAX_VALUE / 2;
			
			for(int i=0;i<n;i++) {
				if(visited[i]) continue;
				if(distance[i] < min) {
					min = distance[i];
					cur = i;
				}
			}
			
			if(cur == end) break;
			
			visited[cur] = true;
			
			for(int i=0;i<n;i++) {
				if(visited[i]) continue;
				if(distance[i] > min + map[cur][i]) {
					distance[i] = min + map[cur][i];
					beforeCity[i] = cur;
				}
			}
		}
		
		List<Integer> path = new ArrayList<>();
		int current = end;
		while(current != -1) {
			path.add(current + 1);
			current = beforeCity[current];
		}
		
		sb.append(distance[end]).append("\n");
		sb.append(path.size()).append("\n");
		for(int i = path.size() - 1 ; i >= 0 ; i--) {
			sb.append(path.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

}
