package com.ohyr.boj.step21.problem09;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		int[] cnt = new int[26];
		
		for(int i=0;i<n;i++) {
			String s = in.readLine();
			cnt[s.charAt(0) - 'a']++;
		}
		
		for(int i=0;i<26;i++) {
			if(cnt[i] >= 5) {
				sb.append((char)(i + 'a'));
			}
		}
		
		System.out.println(sb.toString().equals("") ? "PREDAJA" : sb.toString());
	}

}
