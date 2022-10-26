package com.ohyr.boj.step19.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		
		String s = in.readLine();
		int pm = 1;
		StringBuilder tmp = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '+' || c == '-') {
				answer += pm * Integer.parseInt(tmp.toString());
				tmp = new StringBuilder();
				if(c == '-') {
					pm = -1;
				}
			}else {
				tmp.append(c);
			}
		}
		answer += pm * Integer.parseInt(tmp.toString());
		
		System.out.println(answer);
	}

}
