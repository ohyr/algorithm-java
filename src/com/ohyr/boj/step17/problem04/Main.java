package com.ohyr.boj.step17.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] P = new long[101];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		for(int i=5;i<101;i++) {
			P[i] = P[i-1] + P[i-5];
		}
		
		int T = Integer.parseInt(in.readLine());
		while(T-->0) {
			int N = Integer.parseInt(in.readLine());
			sb.append(P[N]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
