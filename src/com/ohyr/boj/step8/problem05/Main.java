package com.ohyr.boj.step8.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isPrime = new boolean[246913];
		Arrays.fill(isPrime, true);
		for(int i=2;i<=123456;i++) {
			if(!isPrime[i]) continue;
			for(int j=2;i*j<=246912;j++) {
				isPrime[i*j] = false;
			}
		}
		
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n == 0) {
				break;
			}
			
			int sum = 0;
			for(int i=n+1;i<=2*n;i++) {
				if(isPrime[i]) sum++;
			}
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
