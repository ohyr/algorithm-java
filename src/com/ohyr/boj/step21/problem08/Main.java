package com.ohyr.boj.step21.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static final long MOD = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Long n = Long.parseLong(in.readLine());
		
		if(n == 1 || n == 2) {
			System.out.println(1);
			return;
		}
		
		n--;
		
		long[][] fibo = {
			{1, 1},
			{1, 0},
		};
		
		long[][] m = {
			{1, 0},
			{0, 1},
		};
		
		while(n > 0) {
			if(n%2 == 1) {
				m = mul(m, fibo);
			}
			fibo = mul(fibo, fibo);
			
			n /= 2;
		}
		
		System.out.println(m[0][0]);
	}

	private static long[][] mul(long[][] a, long[][] b) {
		long[][] rst = new long[2][2];
		
		for(int k=0;k<2;k++) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					rst[i][j] += a[i][k] * b[k][j];
					rst[i][j] %= MOD;
				}
			}
		}
		
		return rst;
	}

}
