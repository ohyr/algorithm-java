package com.ohyr.boj.class4.problem15666;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static StringBuilder sb = new StringBuilder();
	
	public static int[] numbers;
	public static int[] idx;
	public static List<String> list;
	public static Set<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		numbers = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		idx = new int[m];
		list = new LinkedList<>();
		set = new HashSet<>();
		comb(0, 0, n, m);
		
		for(String ans: list) {
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void comb(int cnt, int start, int n, int r) {
		if(cnt == r) {
			StringBuilder tmp = new StringBuilder();
			for(int i=0;i<r;i++) {
				tmp.append(Integer.toString(idx[i])).append(" ");
			}
			if(set.add(tmp.toString())) {
				list.add(tmp.toString());
			}
			return;
		}
		for(int i=start;i<n;i++) {
			idx[cnt] = numbers[i];
			comb(cnt+1, i, n, r);
		}
	}

}
