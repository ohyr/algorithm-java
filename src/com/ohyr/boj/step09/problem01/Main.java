package com.ohyr.boj.step09.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		boolean[] notPrime = new boolean[1001];
		
		notPrime[1] = true;
		
		for(int i=2;i<1001;i++) {
			for(int j=i;i*j<1001;j++) {
				notPrime[i*j] = true;
			}
		}
		
		int n = Integer.parseInt(in.readLine());
		
		int answer = 0;
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(notPrime[num]) continue;
			
			answer++;
		}
		
		System.out.println(answer);
	}

}
