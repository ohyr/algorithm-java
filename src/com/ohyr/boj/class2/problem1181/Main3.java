package com.ohyr.boj.class2.problem1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main3 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		Set<String> words = new TreeSet<>((a,b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
		
		for(int i=0;i<n;i++) {
			words.add(in.readLine());
		}
		
		for(String word: words) {
			sb.append(word).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
