package com.ohyr.boj.step10.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		String[] words = new String[n];
		
		for(int i=0;i<n;i++) {
			words[i] = in.readLine();
		}
		
		Arrays.sort(words, (a,b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
		
		String prev = words[0];
		sb.append(words[0]).append("\n");
		for(int i=1;i<n;i++) {
			if(prev.equals(words[i])) continue;
			sb.append(words[i]).append("\n");
			prev = words[i];
		}
		System.out.println(sb.toString());
	}

}
