package com.ohyr.boj.step15.problem10;

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
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			
			Map<String,Integer> haebin = new HashMap<>();
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(in.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				
				if(haebin.containsKey(kind)) {
					haebin.put(kind, haebin.get(kind)+1);
				}else {
					haebin.put(kind, 1);
				}
			}
			
			int answer = 1;
			for(int value: haebin.values()) {
				answer *= value+1;
			}
			answer--;
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}