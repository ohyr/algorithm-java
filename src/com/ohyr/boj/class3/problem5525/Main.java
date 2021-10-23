package com.ohyr.boj.class3.problem5525;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		char[] s = new char[m];
		s = in.readLine().toCharArray();
		
		int start = -1;
		int sum = 0;
		int answer = 0;
		
		for(int i=0;i<m;i++) {
			if(start == -1) {
				if(s[i] == 'I') {
					start = 0;
				}
			}else {
				if(start%2 == 0 && s[i] == 'O') {
					start++;
				}else if(start%2 == 1 && s[i] == 'I') {
					start++;
					sum++;
				}else {
					if(sum >= n) answer += sum-n+1;
					sum = 0;
					start = -1;
					i--;
				}
			}
		}
		
		if(sum != 0) {
			if(sum >= n) answer += sum-n+1;
		}
		
		System.out.println(answer);
	}

}
