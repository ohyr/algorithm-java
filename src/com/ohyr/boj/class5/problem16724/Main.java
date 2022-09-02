package com.ohyr.boj.class5.problem16724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int Answer;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][m];
		for(int i=0;i<n;i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		int[][] visited = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visited[i][j] != 0) continue;
				
				dfs(i, j, map, visited);
			}
		}
		
		System.out.println(Answer);
	}
	
	public static void dfs(int x, int y, char[][] map, int[][] visited) {
		visited[x][y] = 1;
		
		int nx = x;
		int ny = y;
		if(map[x][y] == 'U') {
			nx -= 1;
		}else if(map[x][y] == 'D') {
			nx += 1;
		}else if(map[x][y] == 'R') {
			ny += 1;
		}else if(map[x][y] == 'L') {
			ny -= 1;
		}
		
		if(visited[nx][ny] == 0) {
			dfs(nx, ny, map, visited);
		}else if(visited[nx][ny] == 1) {
			Answer++;
		}
		
		visited[x][y] = 2;
	}

}
