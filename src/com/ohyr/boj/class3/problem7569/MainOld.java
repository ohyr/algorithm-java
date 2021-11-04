package com.ohyr.boj.class3.problem7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainOld {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][][] tomato = new int[h][n][m];
		int[][][] tmp = new int[h][n][m];
		
		int green = 0;
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(in.readLine());
				for(int k=0;k<m;k++) {
					int a = Integer.parseInt(st.nextToken());
					tomato[i][j][k] = a;
					tmp[i][j][k] = a;
					if(a == 0) green++;
				}
			}
		}
		
		int answer = 0;
		
		int[][] deltas = {{0,0,1},{0,1,0},{0,0,-1},{0,-1,0},{1,0,0},{-1,0,0}};
		
		while(green != 0) {
			boolean wasteTime = true;
			for(int i=0;i<h;i++) {
				for(int j=0;j<n;j++) {
					for(int k=0;k<m;k++) {
						if(tomato[i][j][k] != 1) continue;
						for(int d=0;d<6;d++) {
							int new_h = i + deltas[d][0];
							int new_n = j + deltas[d][1];
							int new_m = k + deltas[d][2];
							
							if(new_h < 0 || h <= new_h || new_n < 0 || n <= new_n || new_m < 0 || m <= new_m) {
								continue;
							}
	
							if(tmp[new_h][new_n][new_m] == 0) {
								wasteTime = false;
								tmp[new_h][new_n][new_m] = 1;
								green--;
							}
						}
					}
				}
			}
			if(wasteTime) {
				answer = -1;
				break;
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<n;j++) {
					for(int k=0;k<m;k++) {
						tomato[i][j][k] = tmp[i][j][k];
					}
				}
			}
			answer++;
		}
		
		System.out.println(answer);
	}

}
