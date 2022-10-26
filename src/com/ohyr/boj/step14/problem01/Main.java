package com.ohyr.boj.step14.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int answer = Integer.MAX_VALUE;
		
		answer = Math.min(answer, x);
		answer = Math.min(answer, y);
		answer = Math.min(answer, w-x);
		answer = Math.min(answer, h-y);
		
		System.out.println(answer);
	}

}
