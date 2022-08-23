package com.ohyr.boj.class5.problem2467;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = n-1;
		
		int l = 0;
		int r = n-1;
		while(l < r) {
			int cur = a[l] + a[r];
			
			if(Math.abs(cur) < min) {
				min = Math.abs(cur);
				ans1 = a[l];
				ans2 = a[r];
			}
			
			if(cur < 0) {
				l++;
			}else if(cur > 0) {
				r--;
			}else {
				break;
			}
		}
		
		System.out.println(sb.append(ans1).append(" ").append(ans2).toString());
	}

}
