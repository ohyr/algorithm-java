package com.ohyr.boj.step18.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] tempa = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			tempa[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0;i<k;i++) {
			sum += tempa[i];
		}
		
		int answer = sum;

		for(int i=k;i<n;i++) {
			sum += tempa[i];
			sum -= tempa[i-k];
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}

}
