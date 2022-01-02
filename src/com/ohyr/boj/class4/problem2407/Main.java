package com.ohyr.boj.class4.problem2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[][] comb = new String[102][102];
		for(int i=0;i<102;i++) {
			for(int j=0;j<102;j++) {
				comb[i][j] = "0";
			}
		}
		comb[0][0] = "1";
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<i+1;j++) {
				comb[i+1][j] = addBig(comb[i+1][j], comb[i][j]);
				comb[i+1][j+1] = addBig(comb[i+1][j+1], comb[i][j]);
			}
		}
		
		System.out.println(comb[n][m]);
	}
	
	private static String addBig(String a, String b) {
		BigInteger A = new BigInteger(a);
		BigInteger B = new BigInteger(b);
		
		return A.add(B).toString();
	}
}
