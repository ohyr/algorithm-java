package com.ohyr.boj.class5.problem2166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] x = new int[n+1];
		int[] y = new int[n+1];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		x[n] = x[0];
		y[n] = y[0];
		
		long sumA = 0;
		long sumB = 0;
		
		for(int i=0;i<n;i++) {
			sumA += (long) x[i]*y[i+1];
			sumB += (long) x[i+1]*y[i];
		}
		
		System.out.println(String.format("%.1f", Math.abs(sumA - sumB) / 2.0));
	}

}
