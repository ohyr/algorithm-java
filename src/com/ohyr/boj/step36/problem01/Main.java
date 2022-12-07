package com.ohyr.boj.step36.problem01;

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
		
		int m = Integer.parseInt(in.readLine());
		
		Set<Integer> S = new HashSet<>();
		Set<Integer> all = new HashSet<>();
		for(int i=1;i<=20;i++) {
			all.add(i);
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "add":
				S.add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				S.remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				if(S.contains(Integer.parseInt(st.nextToken()))) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				int x = Integer.parseInt(st.nextToken());
				if(S.contains(x)) {
					S.remove(x);
				}else {
					S.add(x);
				}
				break;
			case "all":
				S = new HashSet<>();
				S.addAll(all);
				break;
			case "empty":
				S.clear();
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
