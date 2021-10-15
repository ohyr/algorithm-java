package com.ohyr.boj.class3.problem2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[] steps = new int[n];
		for(int i=0;i<n;i++) {
			steps[i] = Integer.parseInt(in.readLine());
		}
		
		int[][] dp = new int[n+2][2];

		for(int i=2;i<n+2;i++) {
			dp[i][0] = steps[i-2] + Math.max(dp[i-2][0], dp[i-2][1]);
			dp[i][1] = steps[i-2] + dp[i-1][0];
		}
		
		System.out.println(Math.max(dp[n+1][0], dp[n+1][1]));
	}
//		10	10 0 10 1
//		20	20 0 30 1
//		15	25 0 35 1
//		25	55 0 50 1
//		10	45 0 65 1
//		20	75 0 65 1
//		처음에 dfs로 짰다가 dp로 고침 50분 걸림..
}
