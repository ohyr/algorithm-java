package com.ohyr.boj.step10.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] xy = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(xy, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++) {
				sb.append(xy[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
