package com.ohyr.boj.step02.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		if(a == b && b == c) {
			answer = 10000 + a*1000;
		}else if(a != b && b != c && c != a) {
			answer = Math.max(a, b);
			answer = Math.max(answer, c);
			answer *= 100;
		}else {
			if(a == b) {
				answer = 1000 + a*100;
			}else if(b == c) {
				answer = 1000 + b*100;
			}else if(c == a) {
				answer = 1000 + c*100;
			}
		}
		
		System.out.println(answer);
	}

}
