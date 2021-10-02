package com.ohyr.boj.class3.problem1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	private static void z(int n, int x, int y, int[][] Z) {
		if(n == 2) {
			
			return;
		}
		z(n/2,x,y,Z);
		z(n/2,x,y+n/2,Z);
		z(n/2,x+n/2,y,Z);
		z(n/2,x+n/2,y+n/2,Z);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] Z = new int[n][n];
		
		z(n,0,0,Z);
		
		System.out.println(Z[r][c]);
	}

}
