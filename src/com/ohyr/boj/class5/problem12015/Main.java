package com.ohyr.boj.class5.problem12015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		
		int cnt = 0;
		int[] LIS = new int[n];
		LIS[cnt++] = a[0];
		for(int i=1;i<n;i++) {
			if(LIS[cnt-1] < a[i]) {
				LIS[cnt++] = a[i];
			}else {
				int idx = lowerBound(0, cnt, LIS, a[i]);
				LIS[idx] = a[i];
			}
		}
		System.out.println(cnt);
	}

	public static int lowerBound(int l, int r, int[] data, int target) {
		while(l < r) {
			int mid = (l + r) / 2;
			
			if(data[mid] < target) {
				l = mid + 1;
			}else {
				r = mid;
			}
		}
		return r;
	}
}
