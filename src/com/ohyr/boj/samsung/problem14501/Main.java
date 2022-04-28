package com.ohyr.boj.samsung.problem14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] t = new int[n];
		int[] p = new int[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		Answer = 0;
		comb(0, 0, 0, n, t, p);
		
		System.out.println(Answer);
	}

	private static void comb(int prev, int start, int sum, int n, int[] t, int[] p) {
		if(start >= n) {
			if(start == n) {
				Answer = Math.max(Answer, sum);
			}else {
				Answer = Math.max(Answer, sum - p[prev]);
			}
			return;
		}
		for(int i=start;i<n;i++) {
			int num = t[i];
			comb(i, i + num, sum + p[i], n, t, p);
		}
	}

}
