package com.ohyr.boj.step41.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new long[n+1];
		tree = new long[4*n];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Long.parseLong(in.readLine());
		}
		
		init(1, n, 1);
		
		for(int i=0;i<m+k;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				update(1, n, 1, b, c - arr[b]);
				arr[b] = c;
			}else {
				sb.append(sum(1, n, 1, b, (int) c)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	public static long sum(int start, int end, int node, int left, int right) {
		if(right < start || end < left) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}

	public static void update(int start, int end, int node, int idx, long dif) {
		if(idx < start || end < idx) {
			return;
		}
		
		tree[node] += dif;
		
		if(start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		update(start, mid, node*2, idx, dif);
		update(mid+1, end, node*2+1, idx, dif);
	}
}
