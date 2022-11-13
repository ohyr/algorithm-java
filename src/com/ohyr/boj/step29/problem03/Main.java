package com.ohyr.boj.step29.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		
		int l = 0;
		int r = 0;
		int cur = 0;
		while(true) {
			if(cur >= s) {
				answer = Math.min(answer, r - l);
				cur -= a[l++];
			}else if(r >= n) {
				break;
			}else {
				cur += a[r++];
			}
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}

}
