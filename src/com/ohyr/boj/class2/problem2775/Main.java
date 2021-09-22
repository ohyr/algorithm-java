package com.ohyr.boj.class2.problem2775;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] apart = new int[15][15];	
		
		for(int i=1;i<=14;i++) {
			apart[0][i] = i;
		}
		
		for(int i=1;i<=14;i++) {
			apart[i][1] = apart[i-1][1];
			for(int j=1;j<=14;j++) {
				apart[i][j] = apart[i][j-1] + apart[i-1][j];
			}
		}
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int k = Integer.parseInt(in.readLine());
			int n = Integer.parseInt(in.readLine());
			
			System.out.println(apart[k][n]);
		}
	}

}
