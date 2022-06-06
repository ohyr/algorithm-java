package com.ohyr.boj.samsung.problem16234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static boolean IsFin;
	public static int Cnt;
	public static int Sum;
	public static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		while(true) {
			IsFin = true;
			
			int[][] visited = new int[n][n];
			int vis = 0;
			
			Map<Integer, Integer> hmap = new HashMap<>();
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(visited[i][j] != 0) continue;
					vis++;
					Cnt = 1;
					Sum = a[i][j];
					visited[i][j] = vis;
					dfs(i, j, a, visited, n, l, r, vis);
					hmap.put(vis, Sum / Cnt);
				}
			}

			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(visited[i][j] == 0) continue;
					a[i][j] = hmap.get(visited[i][j]);
				}
			}
			
			if(IsFin) break;
			answer++;
		}
		
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y, int[][] a, int[][] visited, int n, int l, int r, int vis) {
		for(int d=0;d<4;d++) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			if(nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
			
			int abs = Math.abs(a[x][y] - a[nx][ny]);
			
			if(abs < l || r < abs) continue;
			
			if(visited[nx][ny] != 0) continue;
			visited[nx][ny] = vis;
			Cnt++;
			Sum += a[nx][ny];
			
			IsFin = false;
			
			dfs(nx, ny, a, visited, n, l, r, vis);
		}
	}

}
