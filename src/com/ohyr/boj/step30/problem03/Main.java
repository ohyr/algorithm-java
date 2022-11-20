package com.ohyr.boj.step30.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] lis = new int[n];
		int[] ck = new int[n];
		int cnt = 0;
		for(int i=0;i<n;i++) {
			int idx = lowerBound(0, cnt, lis, a[i]);
			if(idx >= cnt) {
				ck[i] = cnt;
				lis[cnt++] = a[i];
			}else {
				ck[i] = idx;
				lis[idx] = a[i];
			}
		}
		
		sb.append(cnt--).append("\n");
		
		List<Integer> list = new ArrayList<>();
		for(int i=n-1;i>=0;i--) {
			if(ck[i] == cnt) {
				list.add(a[i]);
				cnt--;
			}
		}
		
		for(int i=list.size()-1;i>=0;i--) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
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
