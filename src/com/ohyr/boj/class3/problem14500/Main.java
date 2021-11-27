package com.ohyr.boj.class3.problem14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int Answer;
	public static int[][] deltas;
	public static boolean[][] visited;
	
	private static void dfs(int x, int y, int cnt, int sum, int n, int m, int[][] paper) {
		if(cnt == 4) {
			Answer = Math.max(Answer, sum);
			return;
		}
		
		if(x < 0 || n <= x || y < 0 || m <= y) return;
		if(visited[x][y]) return;
		visited[x][y] = true;
				
		for(int d=0;d<3;d++) {
			dfs(x+deltas[d][0], y+deltas[d][1], cnt+1, sum+paper[x][y], n, m, paper);
		}
		
		visited[x][y] = false;
	}
	
	private static void middleFingerShape(int x, int y, int n, int m, int[][] paper) {
		int[][] dirList = {
			{1,1,1,0},{0,1,1,1},
			{1,0,1,1},{1,1,0,1},
		};
		
		for(int[] dir: dirList) {
			int sum = paper[x][y];
			for(int d=0;d<4;d++) {
				if(dir[d] == 0) continue;
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx < 0 || n <= nx || ny < 0 || m <= ny) {
					sum = 0;
					break;
				}
				
				sum += paper[nx][ny];
			}
			Answer = Math.max(Answer, sum);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] paper = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Answer = 0;
		deltas = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				dfs(i, j, 0, 0, n, m, paper);
				middleFingerShape(i, j, n, m, paper);
			}
		}
		
		System.out.println(Answer);
	}

}
