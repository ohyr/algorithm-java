package com.ohyr.boj.step14.problem09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int[][] C = new int[30][30];
		C[0][0] = 1;
		for(int i=1;i<30;i++) {
			for(int j=0;j<=i;j++) {
				int cur = C[i-1][j];
				if(j > 0) {
					cur += C[i-1][j-1];
				}
				C[i][j] = cur;
			}
		}
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(C[m][n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
