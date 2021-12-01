package com.ohyr.boj.class3.problem17626;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[50001];
		
		for(int i=0;i<=223;i++) {
			for(int j=i;j<=223;j++) {
				for(int k=j;k<=223;k++) {
					for(int l=k;l<=223;l++) {
						int sum = i*i + j*j + k*k + l*l;
						if(sum > 50000) break;
						if(dp[sum] != 0) continue;
						dp[i*i + j*j + k*k + l*l] = (i==0?0:1) + (j==0?0:1) + (k==0?0:1) + (l==0?0:1);
					}
				}
			}
		}
		
		int n = Integer.parseInt(in.readLine());
		
		System.out.println(dp[n]);
	}

}
