package com.ohyr.boj.step05.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] paper = new int[100][100];
		
		for(int p=0;p<n;p++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
