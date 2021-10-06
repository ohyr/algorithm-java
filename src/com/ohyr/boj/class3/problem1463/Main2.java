package com.ohyr.boj.class3.problem1463;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dp = new int[1000001];
		for(int i=2;i<=1000000;i++) {
			int min = dp[i-1]+1;
			if(i%3==0) min = Math.min(min, dp[i/3]+1);
			if(i%2==0) min = Math.min(min, dp[i/2]+1);
			dp[i] = min;
		}
		
		int n = sc.nextInt();
		sc.close();
		
		System.out.println(dp[n]);
	}

}
