package com.ohyr.boj.class4.problem11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] A = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS = new int[n];
		
		int max = 0;
		for(int i=0;i<n;i++) {
			LIS[i] = 1;
			
			for(int j=0;j<i;j++) {
				if(A[j] < A[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			
			max = Math.max(max, LIS[i]);
		}
		
		System.out.println(max);
	}

}
