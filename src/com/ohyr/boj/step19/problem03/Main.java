package com.ohyr.boj.step19.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] time = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		int answer = 0;
		
		for(int i=0;i<n;i++) {
			answer += time[i]*(n-i);
		}
		
		System.out.println(answer);
	}

}
