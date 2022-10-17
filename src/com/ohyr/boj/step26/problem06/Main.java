package com.ohyr.boj.step26.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		int v = Integer.parseInt(st.nextToken());
		
		boolean[][] mapDFS = new boolean[n+1][n+1];
		boolean[][] mapBFS = new boolean[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			mapDFS[x][y] = true;
			mapDFS[y][x] = true;
			mapBFS[x][y] = true;
			mapBFS[y][x] = true;
		}
		
		mapDFS[v][v] = true;
		dfs(n, v, mapDFS, sb);

		sb.append("\n");
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		mapBFS[v][v] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(int i=1;i<=n;i++) {
				if(mapBFS[cur][i] && !mapBFS[i][i]) {
					mapBFS[i][i] = true;
					q.offer(i);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n, int v, boolean[][] map, StringBuilder sb) {
		sb.append(v).append(" ");
		
		for(int i=1;i<=n;i++) {
			if(map[v][i] && !map[i][i]) {
				map[i][i] = true;
				dfs(n, i, map, sb);
			}
		}
	}

}
