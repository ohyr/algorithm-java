package com.ohyr.boj.step17.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static int cnt1, cnt2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		
		cnt1 = 0;
		cnt2 = 0;
		
		fib(n);
		fibonacci(n);
		
		System.out.println(sb.append(cnt1).append(" ").append(cnt2).toString());
	}

	public static int fib(int n) {
		if(n == 1 || n == 2) {
			cnt1++;
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}
	
	public static int fibonacci(int n) {
		int[] f = new int[n+1];
		f[1] = 1;
		f[2] = 1;
		for(int i=3;i<=n;i++) {
			cnt2++;
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}
}
