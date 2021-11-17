package com.ohyr.boj.class3.problem10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	public static boolean[][] visited;

	private static void dfs(int x, int y, char c, int n, char[][] image) {
		for(int d=0;d<4;d++) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			if(nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
			if(c != image[nx][ny]) continue;
			if(visited[nx][ny]) continue;
			visited[nx][ny] = true;
			
			dfs(nx,ny,c,n,image);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		char[][] image = new char[n][n];
		
		for(int i=0;i<n;i++) {
			image[i] = in.readLine().toCharArray().clone();
		}
		
		int normal = 0;
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j]) continue;
				dfs(i, j, image[i][j], n, image);
				normal++;
			}
		}
		
		int redGreen = 0;
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(image[i][j] == 'G') {
					image[i][j] = 'R';
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j]) continue;
				dfs(i, j, image[i][j], n, image);
				redGreen++;
			}
		}
		
		sb.append(normal).append(" ").append(redGreen);
		System.out.println(sb.toString());
	}

}
