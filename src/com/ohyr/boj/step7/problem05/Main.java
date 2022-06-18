package com.ohyr.boj.step7.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int xx = (n-1)/h + 1;
			int yy = (n-1)%h + 1;
			
			sb.append(yy);
			if(xx < 10) sb.append(0);
			sb.append(xx).append("\n");
		}
		System.out.println(sb.toString());
	}

}
