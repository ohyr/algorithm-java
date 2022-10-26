package com.ohyr.boj.step16.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		idx = new int[m];
		
		perm(0, n, m, sb);
		
		System.out.println(sb.toString());
	}
	
	private static void perm(int cnt, int n, int m, StringBuilder sb) {
		if(cnt == m) {
			for(int i=0;i<m;i++) {
				sb.append(idx[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			idx[cnt] = i;
			perm(cnt+1, n, m, sb);
		}
	}

}
