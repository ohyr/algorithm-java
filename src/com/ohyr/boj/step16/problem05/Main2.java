package com.ohyr.boj.step16.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] num = new int[n+1];
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=n;i++) {
			num[i] = num[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MIN_VALUE;
		
		for(int i=0;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				answer = Math.max(answer, num[j] - num[i]);
			}
		}
		
		System.out.println(answer);
	}

}
