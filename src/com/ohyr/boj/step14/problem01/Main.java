package com.ohyr.boj.step14.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0) {
				break;
			}
			
			String ans = "neither";
			
			if(b % a == 0) {
				ans = "factor";
			}else if(a % b == 0) {
				ans = "multiple";
			}
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
