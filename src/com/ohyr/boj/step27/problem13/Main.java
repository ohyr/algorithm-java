package com.ohyr.boj.step27.problem13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static final int[][] deltas = {{0,0,1},{0,1,0},{0,0,-1},{0,-1,0},{1,0,0},{-1,0,0}};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][][] tomato = new int[h][n][m];
		
		int greenTomatoNum = 0;
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(in.readLine());
				for(int k=0;k<m;k++) {
					int a = Integer.parseInt(st.nextToken());
					tomato[i][j][k] = a;
					if(a == 0) greenTomatoNum++;
				}
			}
		}
		
		int answer = 0;
		
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(tomato[i][j][k] == 1) {
						q.offer(new int[] {i, j, k, 1});
					}
				}
			}
		}

		while(greenTomatoNum != 0) {
			if(q.isEmpty()) {
				answer = -1;
				break;
			}

			int[] redTomato = q.poll();
			int day = redTomato[3];
			for(int d=0;d<6;d++) {
				int nX = redTomato[0] + deltas[d][0];
				int nY = redTomato[1] + deltas[d][1];
				int nZ = redTomato[2] + deltas[d][2];
				
				if(nX < 0 || h <= nX || nY < 0 || n <= nY || nZ < 0 || m <= nZ) {
					continue;
				}
				
				if(tomato[nX][nY][nZ] == 0) {
					tomato[nX][nY][nZ] = 1;
					q.offer(new int[]{nX, nY, nZ, day+1});
					greenTomatoNum--;
				}
			}
			
			if(greenTomatoNum == 0) {
				answer = day;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
