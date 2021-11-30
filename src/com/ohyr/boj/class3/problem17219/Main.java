package com.ohyr.boj.class3.problem17219;

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
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> pwMap = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			String key = st.nextToken();
			String value = st.nextToken();
			
			pwMap.put(key, value);
		}
		
		for(int i=0;i<m;i++) {
			sb.append(pwMap.get(in.readLine())).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
