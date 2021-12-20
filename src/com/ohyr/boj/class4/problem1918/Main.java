package com.ohyr.boj.class4.problem1918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] inorder = in.readLine().toCharArray();
		
		Stack<Character> stk = new Stack<>();
		
		for(int i=0;i<inorder.length;i++) {
			char cur = inorder[i];
			
			if('A' <= cur && cur <= 'Z') {
				sb.append(cur);
				continue;
			}
			
			if(cur == '(') {
				stk.add(cur);
			}else if(cur == '*' || cur == '/') {
				while(!stk.isEmpty() && (stk.peek() == '*' || stk.peek() == '/')) {
					sb.append(stk.pop());
				}
				stk.add(cur);
			}else if(cur == '+' || cur == '-') {
				while(!stk.isEmpty() && stk.peek() != '(') {
					sb.append(stk.pop());
				}
				stk.add(cur);
			}else if(cur == ')') {
				while(stk.peek() != '(') {
					sb.append(stk.pop());
				}
				stk.pop();
			}
		}
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		
		System.out.println(sb.toString());
	}

}
