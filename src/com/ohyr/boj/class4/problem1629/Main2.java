package com.ohyr.boj.class4.problem1629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		long answer = 1;
		
		for(long i=0;i<b;i++) {
			answer *= a;
			answer %= c;
		}
		
		System.out.println(answer);
	}

}
