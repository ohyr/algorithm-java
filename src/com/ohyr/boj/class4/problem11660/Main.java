package com.ohyr.boj.class4.problem11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = map[i][j] + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(map[x2][y2] + map[x1-1][y1-1] - map[x1-1][y2] - map[x2][y1-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
