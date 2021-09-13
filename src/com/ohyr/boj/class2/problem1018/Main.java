package com.ohyr.boj.class2.problem1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n][m];
		
		for(int i=0;i<n;i++) {
			char[] rL = in.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(rL[j] == 'W'){
					board[i][j] = 1;
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		int sum = 0;
		int r = 0;
		
		for(int i=0;i<n-7;i++) {
			for(int j=0;j<m-7;j++) {
				sum = 0;
				r = 0;
				for(int x=i;x<i+8;x++) {
					r++;
					for(int y=j;y<j+8;y++) {
						if(board[x][y] != r%2) {
							sum++;
						}
						r++;
					}
				}
				answer = Math.min(answer, sum);
				
				sum = 0;
				r = 1;
				for(int x=i;x<i+8;x++) {
					r++;
					for(int y=j;y<j+8;y++) {
						if(board[x][y] != r%2) {
							sum++;
						}
						r++;
					}
				}
				answer = Math.min(answer, sum);
			}
		}
		
		System.out.println(answer);
	}

}
