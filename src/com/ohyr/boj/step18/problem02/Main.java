package com.ohyr.boj.step18.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] time = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, (a, b) -> a[0] - b[0]);
		Arrays.sort(time, (a, b) -> a[1] - b[1]);
		
		int cnt = 0;
		int curEnd = 0;
		for(int i=0;i<n;i++) {
			if(curEnd <= time[i][0]) {
				curEnd = time[i][1];
				cnt++;
			}
		}
		System.out.println(sb.append(cnt).toString());
	}

}
