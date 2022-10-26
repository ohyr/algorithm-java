package com.ohyr.boj.step19.problem01;

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
		
		int[] a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(in.readLine());
		}
		
		int answer = 0;
		
		for(int i=n-1;i>=0;--i) {
			int coinNum = k/a[i];
			
			if(coinNum == 0) continue;
			
			answer += coinNum;
			k -= coinNum*a[i];
		}
		
		System.out.println(answer);
	}

}
