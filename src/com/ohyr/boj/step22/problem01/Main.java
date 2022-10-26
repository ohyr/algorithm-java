package com.ohyr.boj.step22.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] WB = new int[2];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] paper = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<n;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		checkPaper(n,0,0,paper);
		
		sb.append(WB[0]).append("\n").append(WB[1]);
		System.out.println(sb.toString());
	}

	private static void checkPaper(int n, int x, int y, int[][] paper) {
		int init = paper[x][y];
		
		boolean perfect = true;
		
		out : for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(init != paper[i][j]) {
					perfect = false;
					break out;
				}
			}
		}
		
		if(perfect) {
			WB[init]++;
		}else {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					checkPaper(n/2,x+n/2*i,y+n/2*j,paper);
				}
			}
		}
	}
}
