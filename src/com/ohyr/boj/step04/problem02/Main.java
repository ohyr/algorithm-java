package com.ohyr.boj.step04.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a < x) {
				sb.append(a).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}

}
