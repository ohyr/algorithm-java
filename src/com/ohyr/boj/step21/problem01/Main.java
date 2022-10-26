package com.ohyr.boj.step21.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		int n = Integer.parseInt(in.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			String cmd = st.nextToken();
			
			switch(cmd) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(q.isEmpty() ? -1 : q.getFirst()).append("\n");
				break;
			case "back":
				sb.append(q.isEmpty() ? -1 : q.getLast()).append("\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
