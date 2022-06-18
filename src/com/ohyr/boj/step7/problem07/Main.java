package com.ohyr.boj.step7.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[5001];
		for(int i=0;i<5001;i++) {
			dp[i] = -1;
		}
		
		for(int i=0;i<1001;i++) {
			int five = 5*i;
			for(int j=0;j<1667;j++) {
				int three = 3*j;
				if(five+three > 5000) continue;
				dp[five+three] = i+j;
			}
		}
		
		int n = Integer.parseInt(in.readLine());
		
		System.out.println(dp[n]);
	}

}
