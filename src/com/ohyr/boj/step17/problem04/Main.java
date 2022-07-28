package com.ohyr.boj.step17.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n+1];
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=n;i++) {
			dp[i] = (dp[i-1] + Integer.parseInt(st.nextToken())) % m;
		}
		
		int[] count = new int[m];
		for(int i=0;i<=n;i++) {
			count[dp[i]]++;
		}
		
		long answer = 0;
		for(int i=0;i<m;i++) {
			answer += (long) count[i] * (count[i] - 1) / 2;
		}
		System.out.println(answer);
	}

}
