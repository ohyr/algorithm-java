package com.ohyr.boj.step10.problem12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] x = new int[n];
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			x[i] = Integer.parseInt(st.nextToken());
			set.add(x[i]);
		}
		
		int[] tmp = set.stream().sorted().mapToInt(Integer::intValue).toArray();
		Map<Integer, Integer> xMap = new HashMap<>();
		for(int i=0;i<set.size();i++) {
			xMap.put(tmp[i], i);
		}
		
		for(int i=0;i<n;i++) {
			sb.append(xMap.get(x[i])).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
