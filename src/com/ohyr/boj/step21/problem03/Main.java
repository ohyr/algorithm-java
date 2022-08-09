package com.ohyr.boj.step21.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] paperNum = new int[3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[][] paper = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		checkPaper(n, paper, 0, 0);
		
		for(int answer: paperNum) {
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void checkPaper(int n, int[][] paper, int x, int y) {
		int init = paper[x][y];
		
		boolean isPerfect = true;

		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(init != paper[i][j]) {
					isPerfect = false;
					break;
				}
			}
			if(isPerfect == false) break;
		}

		if(isPerfect) {
			paperNum[init+1]++;
			return;
		}else {
			n /= 3;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					checkPaper(n, paper, x+i*n, y+j*n);
				}
			}
		}
	}
}
