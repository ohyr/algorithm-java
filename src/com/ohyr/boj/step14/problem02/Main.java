package com.ohyr.boj.step14.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int min = Integer.MAX_VALUE;
		int max = 0;
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(st.nextToken());
			min = Math.min(min, a);
			max = Math.max(max, a);
		}
		System.out.println(min * max);
	}

}
