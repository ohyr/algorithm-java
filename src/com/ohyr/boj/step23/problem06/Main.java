package com.ohyr.boj.step23.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		
		int l = 1;
		int r = k;
		
		while(l < r) {
			int mid = (l + r) / 2;
			int count = 0;
			
			for(int i=1;i<=n;i++) {
				count += Math.min(mid / i, n);
			}
			
			if(k <= count) {
				r = mid;
			}else {
				l = mid + 1;
			}
		}
		
		System.out.println(r);
	}

}
