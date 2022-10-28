package com.ohyr.boj.step10.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		int[] count = new int[10001];
		
		for(int i=0;i<n;i++) {
			count[Integer.parseInt(in.readLine())] += 1;
		}
		
		for(int i=1;i<=10000;i++) {
			for(int j=0;j<count[i];j++) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
