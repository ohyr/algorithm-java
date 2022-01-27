package com.ohyr.boj.class2.problem18111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = Integer.MAX_VALUE;
		int height = 0;
		
		for(int h=256;h>=0;h--) {
			int tmpt = 0;
			int tmpb = b;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					int cur = map[i][j];
					
					if(cur > h) {
						tmpt += 2*(cur - h);
						tmpb += (cur - h);
					}else if(cur < h) {
						tmpt += (h - cur);
						tmpb -= (h - cur);
					}
				}
			}
			
			if(tmpb < 0) continue;
			
			if(tmpt < time) {
				time = tmpt;
				height = h;
			}
		}
		
		sb.append(time).append(" ").append(height);
		System.out.println(sb.toString());
	}

}
