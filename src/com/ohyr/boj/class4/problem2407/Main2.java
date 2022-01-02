package com.ohyr.boj.class4.problem2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[][] comb = new long[102][102];
		comb[0][0] = 1;
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<i+1;j++) {
				comb[i+1][j] += comb[i][j];
				comb[i+1][j+1] += comb[i][j];
			}
		}
		
		System.out.println(comb[n][m]);
	}
}
