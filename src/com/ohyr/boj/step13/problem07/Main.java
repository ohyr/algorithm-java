package com.ohyr.boj.step13.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		
		Set<String> set = new HashSet<>();
		for(int i=1;i<=S.length();i++) {
			for(int j=0;j<S.length() + 1 - i;j++) {
				set.add(S.substring(j, j+i));
			}
		}
		System.out.println(set.size());
	}

}
