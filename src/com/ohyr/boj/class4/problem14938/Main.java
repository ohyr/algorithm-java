package com.ohyr.boj.class4.problem14938;

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
		int r = Integer.parseInt(st.nextToken());
		
		int[] t = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == j) continue;
				map[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int l = Integer.parseInt(st.nextToken());
			
			map[a][b] = l;
			map[b][a] = l;
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		int answer = 0;
		
		for(int i=0;i<n;i++) {
			int sum = t[i];
			for(int j=0;j<n;j++) {
				if(i == j) continue;
				if(map[i][j] <= m) {
					sum += t[j];
				}
			}
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}

}
