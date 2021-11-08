package com.ohyr.boj.class3.problem7662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int k = Integer.parseInt(in.readLine());
			
			TreeMap<Integer,Integer> tm = new TreeMap<>();
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(in.readLine());
				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				
				switch(command) {
				case "I":
					if(tm.containsKey(value)) {
						tm.put(value, tm.get(value)+1);
					}else {
						tm.put(value, 1);
					}
					break;
				case "D":
					if(tm.isEmpty()) continue;
					
					if(value == 1) {
						int max = tm.lastKey();
						if(tm.get(max) == 1) {
							tm.remove(max);
						}else {
							tm.put(max, tm.get(max)-1);
						}
					}else if(value == -1){
						int min = tm.firstKey();
						if(tm.get(min) == 1) {
							tm.remove(min);
						}else {
							tm.put(min, tm.get(min)-1);
						}
					}
					break;
				}
			}
			
			if(tm.isEmpty()) {
				sb.append("EMPTY");
			}else {
				sb.append(tm.lastKey()).append(" ").append(tm.firstKey());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
