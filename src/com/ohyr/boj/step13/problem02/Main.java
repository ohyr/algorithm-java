package com.ohyr.boj.step13.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int ax = Integer.parseInt(st.nextToken());
		int ay = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());
		
		int dx = ax == bx ? cx : bx == cx ? ax : bx;
		int dy = ay == by ? cy : by == cy ? ay : by;
		
		System.out.println(sb.append(dx).append(" ").append(dy));
	}

}
