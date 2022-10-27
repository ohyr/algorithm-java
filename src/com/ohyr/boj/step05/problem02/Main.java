package com.ohyr.boj.step05.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int answer = 0;
		int x = 1;
		int y = 1;
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<9;j++) {
				int cur = Integer.parseInt(st.nextToken());
				if(cur > answer) {
					answer = cur;
					x = i + 1;
					y = j + 1;
				}
			}
		}
		
		sb.append(answer).append("\n").append(x).append(" ").append(y);
		System.out.println(sb.toString());
	}

}
