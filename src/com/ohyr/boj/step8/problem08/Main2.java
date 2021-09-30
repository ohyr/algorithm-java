package com.ohyr.boj.step8.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		
		int len = Math.max(a.length(), b.length());
		
		int[] A = new int[len+1];
		int[] B = new int[len+1];
		
		for(int i=0, j=a.length()-1;i<a.length();i++, j--) {
			A[i] = a.charAt(j) - '0';
		}
		for(int i=0, j=b.length()-1;i<b.length();i++, j--) {
			B[i] = b.charAt(j) - '0';
		}
		
		for(int i=0;i<len;i++) {
			int value = A[i] + B[i];
			A[i] = value%10;
			A[i+1] += value/10;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(A[len] == 0) {
			len--;
		}
		
		for(int i=0;i<len+1;i++) {
			sb.append(A[i]);
		}
		
		System.out.println(sb.reverse());
	}

}
