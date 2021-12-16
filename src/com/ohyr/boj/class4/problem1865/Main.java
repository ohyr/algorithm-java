package com.ohyr.boj.class4.problem1865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(in.readLine());
		
		out : for(int tc=1;tc<=TC;tc++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			int[][] adjMatrix = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i == j) continue;
					adjMatrix[i][j] = Integer.MAX_VALUE / 2;
				}
			}
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int t = Integer.parseInt(st.nextToken());
				
				if(adjMatrix[s][e] > t) {
					adjMatrix[s][e] = t;
				}
				if(adjMatrix[e][s] > t) {
					adjMatrix[e][s] = t;
				}
			}
			for(int i=0;i<w;i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int t = Integer.parseInt(st.nextToken());
				
				adjMatrix[s][e] = -t;
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
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(adjMatrix[i][j] + adjMatrix[j][i] < 0) {
						sb.append("YES").append("\n");
						continue out;
					}
				}
			}
			
			sb.append("NO").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
