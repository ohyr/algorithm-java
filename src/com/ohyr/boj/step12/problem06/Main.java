package com.ohyr.boj.step12.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int a = 0;
		int b = 0;
		
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(st.nextToken()));
			a++;
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				a--;
			}else {
				b++;
			}
		}
		
		System.out.println(a + b);
	}

}
