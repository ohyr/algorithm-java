package com.ohyr.boj.class3.problem11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n+1];
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=n;i++) {
			dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int answer = dp[end] - dp[start-1];
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
