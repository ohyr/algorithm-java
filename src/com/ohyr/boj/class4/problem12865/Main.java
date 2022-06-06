package com.ohyr.boj.class4.problem12865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(in.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n + 1][k + 1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
