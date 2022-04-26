package com.ohyr.boj.samsung.problem13458;

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
		
		st = new StringTokenizer(in.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long answer = 0;
		
		for(int i=0;i<n;i++) {
			A[i] -= B;
			answer++;
			
			if(A[i] > 0) {
				answer += A[i]/C;
				if(A[i]%C != 0) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
