package com.ohyr.boj.step12.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] w = new int[n];
		int[] h = new int[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			int cnt = 0;
			for(int j=0;j<n;j++) {
				if(w[i] < w[j] && h[i] < h[j]) {
					cnt++;
				}
			}
			sb.append(1+cnt).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
