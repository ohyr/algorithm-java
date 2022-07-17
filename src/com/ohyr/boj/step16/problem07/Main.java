package com.ohyr.boj.step16.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] triangle = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=i;j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
			}
		}
		
		int answer = 0;
		
		for(int i=1;i<=n;i++) {
			answer = Math.max(answer, triangle[n][i]);
		}
		
		System.out.println(answer);
	}

}
