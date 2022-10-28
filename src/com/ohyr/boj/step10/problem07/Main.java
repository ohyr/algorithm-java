package com.ohyr.boj.step10.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] n = in.readLine().toCharArray();
		Arrays.sort(n);
		
		for(int i=n.length-1;i>=0;i--) {
			sb.append(n[i]);
		}
		
		System.out.println(sb.toString());
	}

}
