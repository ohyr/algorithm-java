package com.ohyr.boj.step13.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
		
		Map<String,Integer> neverHeard = new HashMap<String,Integer>();
		
		for(int i=0;i<n;i++) {
			String neverHeardMan = in.readLine();
			neverHeard.put(neverHeardMan, 0);
		}
		
		List<String> neverHeardAndSeen = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			String neverSeenMan = in.readLine();
			if(neverHeard.get(neverSeenMan) != null) {
				neverHeardAndSeen.add(neverSeenMan);
			}
		}
		
		String[] answer = neverHeardAndSeen.toArray(new String[neverHeardAndSeen.size()]);
		Arrays.sort(answer);
		
		sb.append(answer.length).append("\n");
		for(int i=0;i<answer.length;i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
