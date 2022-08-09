package com.ohyr.boj.step21.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		long answer = pow(a, b, c);
		
		System.out.println(answer);
	}

	public static long pow(long a, long b, long c) {
		long extra = 1;
		
		while(b > 1) {
			if(b % 2 == 1) {
				extra = (extra * a) % c;
			}
			a = (a * a) % c;
			b /= 2;
		}
		
		return a * extra % c;
	}
}
