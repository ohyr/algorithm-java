package com.ohyr.boj.step19.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		
		Stack<Integer> stk = new Stack<>();
		
		int k = Integer.parseInt(in.readLine());
		for(int i=0;i<k;i++) {
			int cur = Integer.parseInt(in.readLine());
			
			if(cur == 0) {
				stk.pop();
			}else {
				stk.add(cur);
			}
		}
		
		while(!stk.isEmpty()) {
			answer += stk.pop();
		}
		
		System.out.println(answer);
	}

}
