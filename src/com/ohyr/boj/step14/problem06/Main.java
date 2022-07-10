package com.ohyr.boj.step14.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int first = Integer.parseInt(st.nextToken());
		for(int i=1;i<n;i++) {
			int r = Integer.parseInt(st.nextToken());
			
			int g = gcd(first, r);
			sb.append(first/g).append("/").append(r/g).append("\n");
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
