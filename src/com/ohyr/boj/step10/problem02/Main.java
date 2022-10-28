package com.ohyr.boj.step10.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] a = new int[5];
		int sum = 0;
		for(int i=0;i<5;i++) {
			int n = Integer.parseInt(in.readLine());
			a[i] = n;
			sum += n;
		}
		Arrays.sort(a);
		
		sb.append(sum / 5).append("\n");
		sb.append(a[2]).append("\n");
		System.out.println(sb.toString());
	}

}
