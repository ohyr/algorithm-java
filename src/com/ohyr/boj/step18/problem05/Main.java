package com.ohyr.boj.step18.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] l = new int[n-1];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n-1;i++) {
			l[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] w = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0;
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++) {
			min = Math.min(min, w[i]);
			answer += (long) min * l[i];
		}
		
		System.out.println(answer);
	}

}
