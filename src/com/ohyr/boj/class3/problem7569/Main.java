package com.ohyr.boj.class3.problem7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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
		
		int[][] deltas = {{0,0,1},{0,1,0},{0,0,-1},{0,-1,0},{1,0,0},{-1,0,0}};
		
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(tomato[i][j][k] == 1) {
						int[] a = {i,j,k,1};
						q.offer(a);
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
				int new_h = redTomato[0] + deltas[d][0];
				int new_n = redTomato[1] + deltas[d][1];
				int new_m = redTomato[2] + deltas[d][2];
				
				if(new_h < 0 || h <= new_h || new_n < 0 || n <= new_n || new_m < 0 || m <= new_m) {
					continue;
				}
				
				if(tomato[new_h][new_n][new_m] == 0) {
					tomato[new_h][new_n][new_m] = 1;
					q.offer(new int[]{new_h, new_n, new_m, day+1});
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
