package com.ohyr.boj.step21.problem09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) {
				break;
			}
			
			int[] h = new int[n];
			for(int i=0;i<n;i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(getArea(0, n-1, h)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static long getArea(int l, int r, int[] h) {
		if(l == r) {
			return h[l];
		}
		
		int mid = (l + r) / 2;
		
		long leftArea = getArea(l, mid, h);
		long rightArea = getArea(mid+1, r, h);
		
		return Math.max(getMidArea(l, r, mid, h), Math.max(leftArea, rightArea));
	}
	
	public static long getMidArea(int l, int r, int mid, int[] h) {
		int tl = mid;
		int tr = mid;
		
		long height = h[mid];
		long maxArea = height;
		
		while(l < tl && tr < r) {
			if(h[tl-1] < h[tr+1]) {
				tr++;
				height = Math.min(height, h[tr]);
			}else {
				tl--;
				height = Math.min(height, h[tl]);
			}
			
			maxArea = Math.max(maxArea, height * (tr - tl + 1));
		}
		
		while(tr < r) {
			tr++;
			height = Math.min(height, h[tr]);
			maxArea = Math.max(maxArea, height * (tr - tl + 1));
		}
		
		while(l < tl) {
			tl--;
			height = Math.min(height, h[tl]);
			maxArea = Math.max(maxArea, height * (tr - tl + 1));
		}
		
		return maxArea;
	}

}
