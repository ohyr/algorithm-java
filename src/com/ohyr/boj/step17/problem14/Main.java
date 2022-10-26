package com.ohyr.boj.step17.problem14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] A = new int[n];
		int[][] tmp = new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tmp[i][0] = a;
			tmp[i][1] = b;
		}
		Arrays.sort(tmp, (a, b) -> a[0] - b[0]);
		for(int i=0;i<n;i++) {
			A[i] = tmp[i][1];
		}
		
		int[] dp = new int[n];
		for(int i=0;i<n;i++) {
			dp[i] = 1;
			
			for(int j=0;j<i;j++) {
				if(A[j] < A[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int lis = 0;
		for(int i=0;i<n;i++) {
			lis = Math.max(lis, dp[i]);
		}
		System.out.println(n - lis);
	}

}
