package com.ohyr.boj.step14.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] pas = new int[n+1][n+1];
		pas[0][0] = 1;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i+1;j++) {
				int cur = pas[i-1][j];
				if(j-1 >= 0) {
					cur = (cur + pas[i-1][j-1]) % 10007;
				}
				pas[i][j] = cur;
			}
		}
		
		System.out.println(pas[n][k]);
	}

}
