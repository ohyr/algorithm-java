package com.ohyr.boj.step09.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=m;i<=n;i++) {
			if(isPrime(i)) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		if(sum == 0) {
			sb.append(-1);
		}else {
			sb.append(sum).append("\n").append(min);			
		}
		
		System.out.println(sb.toString());
	}

	private static boolean isPrime(int n) {
		if(n == 1) {
			return false;
		}
		
		for(int i=2;i*i<=n;i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
