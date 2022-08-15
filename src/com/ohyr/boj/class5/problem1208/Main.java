package com.ohyr.boj.class5.problem1208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		
		dfs(0, 0, n / 2, s, arr, a);
		dfs(n / 2, 0, n, s, arr, b);
		
		Collections.sort(a);
		Collections.sort(b);
		
		long answer = 0;
		int l = 0;
		int r = b.size()-1;
		while(l < a.size() && r >= 0) {
			int curA = a.get(l);
			int curB = b.get(r);
			int cur = a.get(l) + b.get(r);
			
			if(cur < s) {
				l++;
			}
			if(cur > s) {
				r--;
			}
			if(cur == s) {
				long cntl = 0;
				long cntr = 0;
				
				while(l < a.size() && curA == a.get(l)) {
					cntl++;
					l++;
				}
				while(r >= 0 && curB == b.get(r)) {
					cntr++;
					r--;
				}
				answer += cntl*cntr;
			}
		}
		System.out.println(s == 0 ? answer - 1 : answer);
	}
	
	public static void dfs(int cnt, int sum, int n, int s, int[] arr, List<Integer> a) {
		if(cnt == n) {
			a.add(sum);
			return;
		}
		
		dfs(cnt+1, sum, n, s, arr, a);
		dfs(cnt+1, sum + arr[cnt], n, s, arr, a);
	}
	
}
