package com.ohyr.boj.class2.problem10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(map.get(cur) == null) {
				map.put(cur, 0);
			}
			map.put(cur, map.get(cur) + 1);
		}
		
		int m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(map.get(cur) == null) {
				map.put(cur, 0);
			}			
			sb.append(map.get(cur)).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
