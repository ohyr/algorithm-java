package com.ohyr.boj.step22.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public final static long MOD = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(nCk(n, k));
	}

	private static long nCk(int n, int k) {
		long rst = 0;
		
		long a = factorial(n);
		long b = factorial(k) * factorial(n-k) % MOD;
		
		rst = a * pow(b, MOD-2) % MOD;
		
		return rst;
	}

	private static long pow(long a, long b) {
		long rst = 1L;
		
		while(b > 0) {
			if(b%2 == 1) {
				rst = (rst * a) % MOD;
			}
			a = (a * a) % MOD;
			b /= 2;
		}
		
		return rst;
	}

	private static long factorial(long n) {
		long rst = 1L;
		while(n > 1) {
			rst = (rst * n) % MOD;
			n--;
		}
		return rst;
	}

}
