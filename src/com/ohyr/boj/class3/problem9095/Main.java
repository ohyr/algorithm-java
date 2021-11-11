package com.ohyr.boj.class3.problem9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<12;i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		// 1 - 1
		// 2 - 11		2
		// 3 - 111		12	21 							3
		// 4 - 1111		112 121 211 					13 31 					22
		// 5 - 11111	1112 1121 1211 2111 			113 131 311 			122 212 221 					23 32
		// 6 - 111111	11112 11121 11211 12111 21111	1113 1131 1311 3111		1122 1212 1221 2112 2121 2211 	123 132 213 231 312 321		222		33
		
		// 1 2 4 7 13 24 44 ...
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
