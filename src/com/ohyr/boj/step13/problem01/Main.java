package com.ohyr.boj.step13.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		Set<Integer> set = new HashSet<>();

		int n = Integer.parseInt(in.readLine());		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
		}

		int m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(set.contains(num) ? 1 : 0).append(" ");
		}

		System.out.println(sb.toString());
	}

}
