package com.ohyr.boj.step27.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int Answer;
	static int[][] Cabage;
	static int[][] Deltas = {{1,0},{0,1},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] field = new int[n][m];
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}
			
			Answer = 0;
			Cabage = field;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					int f = field[i][j];
					
					if(f == 0) continue;
					dfs(i,j,n,m);
					Answer++;
				}
			}

			sb.append(Answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void dfs(int i, int j, int n, int m) {
		for(int d=0;d<4;d++) {
			int ni = i + Deltas[d][0];
			int nj = j + Deltas[d][1];
			
			if(ni < 0 || n <= ni || nj < 0 || m <= nj) {
				continue;
			}
			
			if(Cabage[ni][nj] == 1) {
				Cabage[ni][nj] = 0;
				dfs(ni, nj, n, m);
			}
		}
	}

}
