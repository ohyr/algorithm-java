package com.ohyr.boj.step20.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = in.readLine();
			if(str.equals(".")) break;
			
			Stack<Character> stk = new Stack<>();
			
			boolean isBalanced = true;
			
			for(int i=0;i<str.length();i++) {
				char c = str.charAt(i);
				
				if(c == ')') {
					if(!stk.isEmpty() && stk.peek() == '(') {
						stk.pop();
					}else {
						isBalanced = false;
						break;
					}
				}else if(c == ']') {
					if(!stk.isEmpty() && stk.peek() == '[') {
						stk.pop();
					}else {
						isBalanced = false;
						break;
					}
				}else if(c == '(' || c == '['){
					stk.add(c);
				}
			}
			
			if(stk.isEmpty() && isBalanced) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
