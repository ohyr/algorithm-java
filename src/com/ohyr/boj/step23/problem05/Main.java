package com.ohyr.boj.step23.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] x = new int[n];
		for(int i=0;i<n;i++) {
			x[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(x);
		
		int l = 1;
		int r = x[n-1] - x[0] + 1;
		while(l < r) {
			int mid = (l + r) / 2;
			
			if(simul(mid, x) < c) {
				r = mid;
			}else {
				l = mid + 1;
			}
		}
		
		System.out.println(r - 1);
	}
	
	public static int simul(int dis, int[] x) {
		int cnt = 1;
		
		int prev = x[0];
		for(int i=1;i<x.length;i++) {
			int cur = x[i];
			
			if(cur - prev >= dis) {
				cnt++;
				prev = cur;
			}
		}
		
		return cnt;
	}

}
