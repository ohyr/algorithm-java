package com.ohyr.boj.class3.problem1012;

import java.util.Scanner;

public class Main {

	static int Answer;
	static int[][] Cabage;
	static int[][] deltas = {{1,0},{0,1},{0,-1},{-1,0}};
	
	static void dfs(int i, int j, int n, int m) {
		for(int d=0;d<4;d++) {
			int ni = i + deltas[d][0];
			int nj = j + deltas[d][1];
			
			if(ni < 0 || n <= ni || nj < 0 || m <= nj) {
				continue;
			}
			
			if(Cabage[ni][nj] == 1) {
				Cabage[ni][nj] = 0;
				dfs(ni, nj, n, m);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] field = new int[n][m];
			
			for(int i=0;i<k;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
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

			System.out.println(Answer);
		}
		sc.close();
	}

}
