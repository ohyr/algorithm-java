package com.ohyr.boj.step16.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int[][][] dp = new int[21][21][21];
		for(int i=0;i<21;i++) {
			for(int j=0;j<21;j++) {
				dp[0][i][j] = 1;
				dp[i][j][0] = 1;
				dp[i][0][j] = 1;
			}
		}
		
		for(int i=1;i<21;i++) {
			for(int j=1;j<21;j++) {
				for(int k=1;k<21;k++) {
					if(i < j && j < k) {
						dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
					}else {
						dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
					}
				}
			}
		}
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
			
			if(a <= 0 || b <= 0 || c <= 0) {
				a = 0;
				b = 0;
				c = 0;
			}
			
			if(a > 20 || b > 20 || c > 20) {
				a = 20;
				b = 20;
				c = 20;
			}
			
			sb.append(dp[a][b][c]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}
		
		if(a < b && b < c) {
			return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		
		return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}

}
