package com.ohyr.boj.class3.problem1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[] dp = new int[n+1];
		for(int i=2;i<=n;i++) {
			int min = dp[i-1]+1;
			if(i%3==0) min = Math.min(min, dp[i/3]+1);
			if(i%2==0) min = Math.min(min, dp[i/2]+1);
			dp[i] = min;
		}
		
		System.out.println(dp[n]);
	}

}
