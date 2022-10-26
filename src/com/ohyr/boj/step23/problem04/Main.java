package com.ohyr.boj.step23.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = 0;
		
		int[] trees = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		int l = 0;
		int r = max;
		
		while(l < r) {
			int mid = (l + r) / 2;
			
			long sum = cutAndGetSum(mid, trees);
			
			if(sum >= m) {
				l = mid + 1;
			}else {
				r = mid;
			}
		}
		
		System.out.println(l - 1);
	}
	
	private static long cutAndGetSum(int h, int[] trees) {
		long sum = 0;
		
		for(int tree: trees) {
			sum += tree > h ? tree - h : 0;
		}
		
		return sum;
	}
}
