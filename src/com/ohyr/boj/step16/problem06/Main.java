package com.ohyr.boj.step16.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] h = new int[n][3];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			h[i][0] = Integer.parseInt(st.nextToken());
			h[i][1] = Integer.parseInt(st.nextToken());
			h[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
	
		for(int i=1;i<n;i++) {
			h[i][0] += Math.min(h[i-1][1], h[i-1][2]);
			h[i][1] += Math.min(h[i-1][0], h[i-1][2]);
			h[i][2] += Math.min(h[i-1][0], h[i-1][1]);
		}
		
		for(int i=0;i<3;i++) {
			answer = Math.min(answer, h[n-1][i]);
		}
	
		System.out.println(answer);
	}

}
