package com.ohyr.boj.step14.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(a, b);
		
		sb.append(gcd).append("\n").append(a*b/gcd);
		
		System.out.println(sb.toString());
	}

	private static int gcd(int a, int b) {
		while(b > 0) {
			int c = a%b;
			a = b;
			b = c;
		}
		
		return a;
	}

}
