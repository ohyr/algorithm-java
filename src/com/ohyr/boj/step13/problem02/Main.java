package com.ohyr.boj.step13.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			set.add(in.readLine());
		}
		
		int answer = 0;
		for(int i=0;i<m;i++) {
			answer += set.contains(in.readLine()) ? 1 : 0;
		}
		System.out.println(answer);
	}

}
