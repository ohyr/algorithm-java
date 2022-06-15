package com.ohyr.boj.class4.problem11054;

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
		for(int i=0;i<n;i++) {
			LIS[i] = 1;
			
			for(int j=0;j<i;j++) {
				if(A[j] < A[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		
		int[] LDS = new int[n];
		for(int i=n-1;i>=0;i--) {
			LDS[i] = 1;
			
			for(int j=n-1;j>i;j--) {
				if(A[j] < A[i] && LDS[i] < LDS[j] + 1) {
					LDS[i] = LDS[j] + 1;
				}
			}
		}
		
		int answer = 0;
		for(int i=0;i<n;i++) {
			answer = Math.max(answer, LIS[i] + LDS[i] - 1);
		}
		System.out.println(answer);
	}

}
