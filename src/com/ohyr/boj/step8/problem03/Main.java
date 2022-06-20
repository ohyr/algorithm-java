package com.ohyr.boj.step8.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		int k = 2;
		while(n > 1) {
			if(n % k == 0) {
				sb.append(k).append("\n");
				n /= k;
			} else {
				k++;
			}
		}
		
		System.out.println(sb.toString());
	}

}
