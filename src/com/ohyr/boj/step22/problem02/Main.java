package com.ohyr.boj.step22.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static StringBuilder Answer = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] image = new int[n][n];
		
		for(int i=0;i<n;i++) {
			char[] rL = in.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				image[i][j] = rL[j]-'0';
			}
		}

		zip(n, 0, 0, image);
		
		System.out.println(Answer.toString());
	}

	private static void zip(int n, int x, int y, int[][] image) {
		int init = image[x][y];
		boolean zipable = true;
		out : for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(init != image[i][j]) {
					zipable = false;
					break out;
				}
			}
		}
		
		if(zipable) {
			Answer.append(init);
		}else {
			Answer.append("(");
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					zip(n/2, x + n/2*i, y + n/2*j, image);
				}
			}
			Answer.append(")");
		}
	}
}
