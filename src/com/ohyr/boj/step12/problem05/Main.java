package com.ohyr.boj.step12.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int cnt = 0;
		
		String answer = "";
		
		for(int i=0;i<100000000;i++) {
			if(Integer.toString(i).contains("666")) {
				cnt++;
				if(n == cnt) {
					answer = Integer.toString(i);
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
