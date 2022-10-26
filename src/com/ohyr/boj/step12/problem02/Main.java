package com.ohyr.boj.step12.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int answer = 0;
		
		for(int i=1;i<=n;i++) {
			int cur = i;
			int sum = cur;
			while(cur > 0) {
				sum += cur%10;
				cur /= 10;
			}
			if(sum == n) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
