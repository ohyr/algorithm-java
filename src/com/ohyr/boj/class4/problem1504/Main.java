package com.ohyr.boj.class4.problem1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == j) continue;
				adjMatrix[i][j] = 1001;
			}
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			adjMatrix[a][b] = c;
			adjMatrix[b][a] = c;
		}
		
		st = new StringTokenizer(in.readLine());
		int v1 = Integer.parseInt(st.nextToken())-1;
		int v2 = Integer.parseInt(st.nextToken())-1;
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
		
		int answer = adjMatrix[0][v1] + adjMatrix[v1][v2] + adjMatrix[v2][n-1];
		
		answer = Math.min(answer, adjMatrix[0][v2] + adjMatrix[v2][v1] + adjMatrix[v1][n-1]);
		
		if(answer > 1000) answer = -1;
		
		System.out.println(answer);
	}

}
