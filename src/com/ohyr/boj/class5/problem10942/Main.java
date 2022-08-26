package com.ohyr.boj.class5.problem10942;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] palindrome = new int[n][n];
		for(int i=0;i<2*n;i++) {
			int a = i / 2;
			int b = i / 2;
			
			if(i % 2 == 1) {
				b++;
			}
			
			while(0 <= a && b < n) {
				if(arr[a] != arr[b]) {
					break;
				}
				palindrome[a][b] = 1;
				a--;
				b++;
			}
		}
		
		int m = Integer.parseInt(in.readLine());
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(palindrome[s-1][e-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
