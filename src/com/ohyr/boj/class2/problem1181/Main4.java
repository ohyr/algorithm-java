package com.ohyr.boj.class2.problem1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main4 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		Set<String> set = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			set.add(in.readLine());
		}
		
		List<String> list = new ArrayList<>(set);
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		
		for(String word: list) {
			sb.append(word).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
