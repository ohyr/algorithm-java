package com.ohyr.boj.class4.problem9935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		String bomb = in.readLine();
		
		int n = str.length();
		int m = bomb.length();
		
		Stack<Character> stk = new Stack<>();
		
		for(int i=0;i<n;i++) {
			stk.push(str.charAt(i));
			
			if(stk.size() >= m && stk.peek() == bomb.charAt(m - 1)) {
				boolean isBoom = true;
				
				for(int j=0;j<m;j++) {
					if(stk.get(stk.size() - m + j) != bomb.charAt(j)) {
						isBoom = false;
						break;
					}
				}
				
				if(isBoom) {
					for(int j=0;j<m;j++) {
						stk.pop();
					}
				}
			}
		}
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb.reverse().toString());
	}

}
