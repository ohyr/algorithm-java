package com.ohyr.boj.step09.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int answer = 1;
		while(n > 0) answer *= n--;
		
		System.out.println(answer);
	}

}
