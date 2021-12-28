package com.ohyr.boj.class4.problem2096;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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
		}
		
		int[] answer = new int[2];
		
		int[][] dp = new int[2][3];
		
		dp[0][0] = game[0][0];
		dp[0][1] = game[0][1];
		dp[0][2] = game[0][2];
		
		for(int i=1;i<n;i++) {
			dp[1][0] = Math.max(dp[0][0], dp[0][1]) + game[i][0];
			dp[1][1] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])) + game[i][1];
			dp[1][2] = Math.max(dp[0][1], dp[0][2]) + game[i][2];
			
			dp[0] = dp[1].clone();
		}
		answer[0] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
		
		dp[0][0] = game[0][0];
		dp[0][1] = game[0][1];
		dp[0][2] = game[0][2];
		
		for(int i=1;i<n;i++) {
			dp[1][0] = Math.min(dp[0][0], dp[0][1]) + game[i][0];
			dp[1][1] = Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2])) + game[i][1];
			dp[1][2] = Math.min(dp[0][1], dp[0][2]) + game[i][2];
			
			dp[0] = dp[1].clone();
		}
		answer[1] = Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
		
		System.out.println(answer[0] + " " + answer[1]);
	}

}
