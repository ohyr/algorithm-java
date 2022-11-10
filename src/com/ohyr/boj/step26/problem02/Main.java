package com.ohyr.boj.step26.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stk = new Stack<>();
		
		int[] NGE = new int[n];
		for(int i=n-1;i>=0;i--) {
			while(!stk.isEmpty()) {
				if(stk.peek() > a[i]) {
					break;
				}
				stk.pop();
			}
			NGE[i] = stk.isEmpty() ? -1 : stk.peek();
			stk.push(a[i]);
		}
		
		for(int i=0;i<n;i++) {
			sb.append(NGE[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
