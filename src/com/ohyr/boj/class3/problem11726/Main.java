package com.ohyr.boj.class3.problem11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[] dp = new int[n+2];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[n]);
	}

}
// https://programmers.co.kr/learn/courses/30/lessons/12900