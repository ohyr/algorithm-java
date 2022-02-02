package com.ohyr.boj.class4.problem15654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static StringBuilder sb = new StringBuilder();
	public static int[] numbers;
	public static int[] idx;
	
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
		permutation(0, 0, n, m);
		
		System.out.println(sb.toString());
	}

	private static void permutation(int cnt, int flag, int n, int r) {
		if(cnt == r) {
			for(int i=0;i<r;i++) {
				sb.append(idx[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
			if((flag & 1<<i) != 0) continue;
			idx[cnt] = numbers[i];
			permutation(cnt+1, flag|1<<i, n, r);
		}
	}

}
