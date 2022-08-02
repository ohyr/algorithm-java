package com.ohyr.boj.step19.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stk = new Stack<>();
		
		int n = Integer.parseInt(in.readLine());
		int k = 1;
		
		for(int i=0;i<n;i++) {
			int cur = Integer.parseInt(in.readLine());
			
			if(k <= cur) {
				while(k <= cur) {
					stk.push(k++);
					sb.append("+").append("\n");
				}
				stk.pop();
				sb.append("-").append("\n");
			}else {
				if(stk.isEmpty() || (!stk.isEmpty() && stk.peek() < cur)) {
					System.out.println("NO");
					return;
				}
				
				while(true) {
					sb.append("-").append("\n");
					if(stk.pop() == cur) {
						break;
					}
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
