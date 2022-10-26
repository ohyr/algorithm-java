package com.ohyr.boj.step15.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(a*b/gcd(a, b)).append("\n");
		}
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
