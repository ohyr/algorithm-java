package com.ohyr.boj.step11.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int callCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			String S = in.readLine();
			
			callCnt = 0;
			
			sb.append(isPalindrome(S)).append(" ").append(callCnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int isPalindrome(String S) {
		return recursion(S, 0, S.length()-1);
	}
	
	public static int recursion(String S, int l, int r) {
		callCnt++;
		
		if(l >= r) return 1;
		else if(S.charAt(l) != S.charAt(r)) return 0;
		else return recursion(S, l+1, r-1);
	}

}
