package com.ohyr.boj.step09.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		sb = new StringBuilder();
		
		sb.append((1<<n) - 1).append("\n");
		
		hanoi(n, 1, 2, 3);
		
		System.out.println(sb.toString());
	}
	
	private static void hanoi(int n, int a, int b, int c) {
		if(n == 1) {
			sb.append(a).append(" ").append(c).append("\n");
			return;
		}
		
		hanoi(n - 1, a, c, b);
		
		sb.append(a).append(" ").append(c).append("\n");
		
		hanoi(n - 1, b, a, c);
	}

}
