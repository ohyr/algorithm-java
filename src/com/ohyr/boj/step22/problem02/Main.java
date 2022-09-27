package com.ohyr.boj.step22.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int[] checked = new int[20_000_001];
		
		int n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			int cur = Integer.parseInt(st.nextToken()) + 10_000_000;
			checked[cur] += 1;
		}
		
		int m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++) {
			int cur = Integer.parseInt(st.nextToken()) + 10_000_000;
			sb.append(checked[cur]).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
