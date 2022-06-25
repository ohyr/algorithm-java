package com.ohyr.boj.step09.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] fibo = new int[n+2];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2;i<=n;i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[n]);
	}

}
