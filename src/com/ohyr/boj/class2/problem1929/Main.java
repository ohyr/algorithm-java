package com.ohyr.boj.class2.problem1929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] sosu = new int[1000001];
		
		for(int i=2;i<1000001;i++) {
			for(int j=1;j*i<1000001;j++) {
				sosu[j*i]++;
			}
		}
		
		for(int i=m;i<=n;i++) {
			if(sosu[i] == 1) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
