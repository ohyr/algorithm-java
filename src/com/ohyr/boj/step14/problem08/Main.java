package com.ohyr.boj.step14.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		for(int i=0;i<p;i++) {
			st = new StringTokenizer(in.readLine());
			int px = Integer.parseInt(st.nextToken());
			int py = Integer.parseInt(st.nextToken());
			
			if(x <= px && px <= x+w && y <= py && py <= y+h) {
				answer++;
			}else {
				int dist1 = (px - x)*(px - x) + (py-y-(h/2))*(py-y-(h/2));
				int dist2 = (px - x - w)*(px - x - w) + (py-y-(h/2))*(py-y-(h/2));
				if(dist1 > (h/2)*(h/2) && dist2 > (h/2)*(h/2)) continue;

				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
