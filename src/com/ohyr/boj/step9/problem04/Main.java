package com.ohyr.boj.step9.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] stars = new int[n][n];
		
		checkStars(0, 0, n, stars);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(stars[i][j] == 0) {
					sb.append("*");
				}else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void checkStars(int x, int y, int n, int[][] stars) {
		if(n == 1) {
			return;
		}
		
		for(int i=x+n/3;i<x+2*n/3;i++) {
			for(int j=y+n/3;j<y+2*n/3;j++) {
				stars[i][j] = 1;
			}
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i == 1 && j == 1) continue;
				checkStars(x + i*n/3, y + j*n/3, n/3, stars);
			}
		}
	}

}
