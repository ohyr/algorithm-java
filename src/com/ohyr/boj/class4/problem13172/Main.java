package com.ohyr.boj.class4.problem13172;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public final static long MOD = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		long answer = 0;
		
		int m = Integer.parseInt(in.readLine());
		for(int i=0;i<m;i++) {			
			st = new StringTokenizer(in.readLine());
			long n = Long.parseLong(st.nextToken());
			long s = Long.parseLong(st.nextToken());
			answer = (answer + s * powQuick(n, MOD - 2)) % MOD;
		}
		
		System.out.println(answer);
	}
	
	private static long powQuick(long a, long b) {
		long ext = 1;
		while(b > 1) {
			if(b % 2 == 1) {
				ext = (ext * a) % MOD;
			}
			a = (a * a) % MOD;
			b /= 2;
		}
		return a * ext % MOD;
	}
}
