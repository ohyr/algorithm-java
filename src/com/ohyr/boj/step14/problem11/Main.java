package com.ohyr.boj.step14.problem11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int answer = 0;
		
		for(int i=5;i<=n;i+=5) {
			int k = i/5;
			answer++;
			
			while(k > 0) {
				if(k % 5 == 0) {
					answer++;
				}else {
					break;
				}
				
				k /= 5;
			}
		}
		
		System.out.println(answer);
	}

}
