package com.ohyr.boj.step22.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		int[][] m = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				m[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] answer = matrix(n, b, m);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static int[][] matrix(int n, long b, int[][] m) {
		int[][] rst = new int[n][n];
		for(int i=0;i<n;i++) {
			rst[i][i] = 1;
		}
		
		while(b > 0) {
			if(b%2 == 1) {
				rst = mul(rst, m);
			}
			b /= 2;
			m = mul(m, m);
		}
		
		return rst;
	}

	private static int[][] mul(int[][] a, int[][] b) {
		int n = a.length;
		int[][] rst = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					rst[i][j] += a[i][k] * b[k][j] % 1000;
					rst[i][j] %= 1000;
				}
			}
		}
		
		return rst;
	}

}
