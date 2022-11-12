package com.ohyr.boj.step29.problem01;

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
		
		int x = Integer.parseInt(in.readLine());
		
		int answer = 0;
		
		Arrays.sort(a);
		
		int l = 0;
		int r = n - 1;
		
		while(l < r) {
			if(a[l] + a[r] == x) {
				answer++;
			}
			
			if(a[l] + a[r] < x) {
				l++;
			}else {
				r--;
			}
		}
		
		System.out.println(answer);
	}

}
