package com.ohyr.boj.samsung.problem14503;

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
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
		
		int answer  = 0;
		
		//clean
		
		boolean isCleanNow = true;
		while(true) {
			if(isCleanNow && room[r][c] == 0) {
				room[r][c] = 2;
				answer++;
			}
			
			boolean goBack = true;
			for(int i=0;i<4;i++) {
				int nr = r + deltas[(d+i)%4][0];
				int nc = c + deltas[(d+i)%4][1];
				
				if(room[nr][nc] == 0) goBack = false;
			}
			if(goBack) {
				int nr = r + deltas[(d+2)%4][0];
				int nc = c + deltas[(d+2)%4][1];
				if(room[nr][nc] == 1) {
					break;
				}
				r = nr;
				c = nc;
				isCleanNow = false;
				continue;
			}
			
			for(int i=0;i<4;i++) {
				int nr = r + deltas[(d+3-i)%4][0];
				int nc = c + deltas[(d+3-i)%4][1];
				if(room[nr][nc] == 0) {
					r = nr;
					c = nc;
					d = (d+3-i)%4;
					isCleanNow = true;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
