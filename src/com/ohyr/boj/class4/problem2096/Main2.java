package com.ohyr.boj.class4.problem2096;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] game = new int[n][6];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			game[i][0] = Integer.parseInt(st.nextToken());
			game[i][1] = Integer.parseInt(st.nextToken());
			game[i][2] = Integer.parseInt(st.nextToken());
			game[i][3] = game[i][0];
			game[i][4] = game[i][1];
			game[i][5] = game[i][2];
		}
		
		for(int i=1;i<n;i++) {
			game[i][0] += Math.max(game[i-1][0], game[i-1][1]);
			game[i][1] += Math.max(game[i-1][0], Math.max(game[i-1][1], game[i-1][2]));
			game[i][2] += Math.max(game[i-1][1], game[i-1][2]);
			game[i][3] += Math.min(game[i-1][3], game[i-1][4]);
			game[i][4] += Math.min(game[i-1][3], Math.max(game[i-1][4], game[i-1][5]));
			game[i][5] += Math.min(game[i-1][4], game[i-1][5]);
		}
		
		int max = Math.max(game[n-1][0], Math.max(game[n-1][1], game[n-1][2]));
		int min = Math.min(game[n-1][3], Math.min(game[n-1][4], game[n-1][5]));
		
		System.out.println(max + " " + min);
	}

}
