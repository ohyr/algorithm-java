package com.ohyr.boj.step27.problem12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static final int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] tomato = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int greenTomatoNum = 0;
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tomato[i][j] == 0) {
					greenTomatoNum++;
				}else if(tomato[i][j] == 1) {
					q.offer(new int[]{i, j, 1});
				}
			}
		}
		
		int answer = 0;
		
		while(greenTomatoNum != 0) {
			if(q.isEmpty()) {
				answer = -1;
				break;
			}
			
			int[] redTomato = q.poll();
			int day = redTomato[2];
			
			for(int d=0;d<4;d++) {
				int nX = redTomato[0] + deltas[d][0];
				int nY = redTomato[1] + deltas[d][1];
				
				if(nX < 0 || n <= nX || nY < 0 || m <= nY) continue;
				
				if(tomato[nX][nY] == 0) {
					tomato[nX][nY] = 1;
					q.offer(new int[] {nX, nY, day+1});
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
