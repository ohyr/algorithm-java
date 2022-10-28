package com.ohyr.boj.step10.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] score = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(score);
		
		System.out.println(score[n - k]);
	}

}
