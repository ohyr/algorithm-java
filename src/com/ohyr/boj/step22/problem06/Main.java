package com.ohyr.boj.step22.problem06;

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
		int m = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		int m2 = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] b = new int[m2][k];
		for(int i=0;i<m2;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<k;j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] c = new int[n][k];
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				for(int z=0;z<m;z++) {
					c[i][j] += a[i][z] * b[z][j];
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				sb.append(c[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
