package com.ohyr.boj.class4.problem15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static StringBuilder sb = new StringBuilder();
	public static int[] idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		idx = new int[m];
		permutation(0, 0, n, m);
		
		System.out.println(sb.toString());
	}

	private static void permutation(int cnt, int start, int n, int m) {
		if(cnt == m) {
			for(int i=0;i<m;i++) {
				sb.append(idx[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<n;i++) {
			idx[cnt] = i+1;
			permutation(cnt+1, i+1, n, m);
		}
	}

}
