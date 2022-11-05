package com.ohyr.boj.step04.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int v = Integer.parseInt(in.readLine());
		
		int answer = 0;
		for(int i=0;i<n;i++) {
			if(arr[i] == v) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
