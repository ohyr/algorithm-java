package com.ohyr.boj.step29.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int l = 0;
		int r = n - 1;
		int min = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		while(l < r) {
			int cur = a[l] + a[r];
			
			if(min > Math.abs(cur)) {
				min = Math.abs(cur);
				ans1 = a[l];
				ans2 = a[r];
			}
			
			if(cur < 0) {
				l++;
			}else {
				r--;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}

}
