package com.ohyr.boj.step21.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		int n = Integer.parseInt(in.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			if("push_front".equals(command)) {
				dq.offerFirst(Integer.parseInt(st.nextToken()));
			}else if("push_back".equals(command)) {
				dq.offerLast(Integer.parseInt(st.nextToken()));
			}else if("pop_front".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(dq.pollFirst()).append("\n");
			}else if("pop_back".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(dq.pollLast()).append("\n");
			}else if("size".equals(command)) {
				sb.append(dq.size()).append("\n");
			}else if("empty".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}else if("front".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(dq.peekFirst()).append("\n");
			}else if("back".equals(command)) {
				if(dq.isEmpty()) {
					sb.append("-1").append("\n");
					continue;
				}
				sb.append(dq.peekLast()).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
