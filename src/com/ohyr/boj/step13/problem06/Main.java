package com.ohyr.boj.step13.problem06;

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
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			
			int dist = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
			int pr = (r1 + r2)*(r1 + r2);
			int mr = (r1 - r2)*(r1 - r2);
			
			if(dist == pr) {
				answer = 1;
			}else if(dist < pr) {
				if(dist == mr) {
					answer = 1;
				}else if(dist > mr) {
					answer = 2;
				}
			}
			
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				answer = -1;
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
