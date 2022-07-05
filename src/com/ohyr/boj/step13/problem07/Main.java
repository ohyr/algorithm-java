package com.ohyr.boj.step13.problem07;

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
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			
			int n = Integer.parseInt(in.readLine());
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(in.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int cr = Integer.parseInt(st.nextToken());
				
				int dist1 = (cx - x1)*(cx - x1) + (cy - y1)*(cy - y1);
				int dist2 = (cx - x2)*(cx - x2) + (cy - y2)*(cy - y2);
				int r = cr*cr;
				
				if(dist1 < r && dist2 > r) {
					answer += 1;
				}else if(dist1 > r && dist2 < r) {
					answer += 1;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
