package com.ohyr.boj.step17.problem11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[] wine = new int[n+2];
		for(int i=1;i<=n;i++) {
			wine[i] = Integer.parseInt(in.readLine());
		}
		
		int[] dp = new int[n+2];
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
		}
		System.out.println(dp[n]);
	}

}
