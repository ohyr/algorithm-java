package com.ohyr.boj.step20.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		Stack<Integer> stk = new Stack<>();
		
		int n = Integer.parseInt(in.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			if("push".equals(command)) {
				int num = Integer.parseInt(st.nextToken());
				stk.push(num);
			}else if("pop".equals(command)) {
				if(stk.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(stk.pop()).append("\n");
				}
			}else if("size".equals(command)) {
				sb.append(stk.size()).append("\n");
			}else if("empty".equals(command)) {
				if(stk.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}else if("top".equals(command)) {
				if(stk.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(stk.peek()).append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
