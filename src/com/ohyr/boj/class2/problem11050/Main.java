package com.ohyr.boj.class2.problem11050;

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
		
		int answer = 1;
		
		for(int i=0;i<k;i++) {
			answer *= n-i;
		}
		
		for(int i=k;i>0;--i) {
			answer /= i;
		}
		
		System.out.println(answer);
	}

}
