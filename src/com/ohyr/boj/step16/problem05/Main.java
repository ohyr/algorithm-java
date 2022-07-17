package com.ohyr.boj.step16.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] num = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = num[0];
		
		int[] dp = new int[n];
		dp[0] = num[0];
		for(int i=1;i<n;i++) {
			dp[i] = Math.max(dp[i-1] + num[i], num[i]);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}

}
