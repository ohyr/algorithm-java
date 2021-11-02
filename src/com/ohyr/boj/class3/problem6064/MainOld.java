package com.ohyr.boj.class3.problem6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainOld {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			int answer = -1;
			
			for(int k=0;k<m*n;k++) {
				if(k%m == x && k%n == y) {
					answer = k+1;
					break;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
