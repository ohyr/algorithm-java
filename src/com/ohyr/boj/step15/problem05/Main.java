package com.ohyr.boj.step15.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		int m = Math.abs(num[0] - num[1]);
		for(int i=2;i<n;i++) {
			m = gcd(m, Math.abs(num[i-1] - num[i]));
		}
		
		for(int i=2;i<=m/2;i++) {
			if(m % i == 0) {
				sb.append(i).append(" ");
			}
		}
		sb.append(m);
		System.out.println(sb.toString());
	}

	public static int gcd(int a, int b) {
		int r = a % b;
		if(r == 0) {
			return b;
		}
		return gcd(b, r);
	}
}
