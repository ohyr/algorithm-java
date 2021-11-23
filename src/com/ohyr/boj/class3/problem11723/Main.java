package com.ohyr.boj.class3.problem11723;

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
			int x = 0;
			if(!(command.equals("all") || command.equals("empty"))) {
				x = Integer.parseInt(st.nextToken());
			}
			
			switch(command) {
			case "add":
				S.add(x);
				break;
			case "remove":
				S.remove(x);
				break;
			case "check":
				if(S.contains(x)) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case "toggle":
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
