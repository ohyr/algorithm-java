package com.ohyr.boj.class3.problem11279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
		
		int n = Integer.parseInt(in.readLine());
		
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(in.readLine());
			
			switch(x) {
			case 0:
				if(q.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(q.poll()).append("\n");
				}
				break;
			default:
				q.offer(x);
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
