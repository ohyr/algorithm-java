package com.ohyr.boj.class4.problem1238;

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
		int x = Integer.parseInt(st.nextToken())-1;
		
		int[][] adjMatrix = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == j) continue;
				adjMatrix[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			
			adjMatrix[a][b] = t;
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
		
		int answer = 0;
		
		for(int i=0;i<n;i++) {
			int cur = adjMatrix[i][x] + adjMatrix[x][i];
			
			answer = Math.max(answer, cur);
		}
		
		System.out.println(answer);
	}

}
