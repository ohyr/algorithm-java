package com.ohyr.boj.step14.problem12;

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
		
		int a = cntFac(n, 5) - cntFac(n - m, 5) - cntFac(m, 5);
		int b = cntFac(n, 2) - cntFac(n - m, 2) - cntFac(m, 2);
		
		System.out.println(Math.min(a, b));
	}
	
	public static int cntFac(int n, int k) {
		int cnt = 0;
		while(n > 1) {
			cnt += n / k;
			n /= k;
		}
		return cnt;
	}

}
