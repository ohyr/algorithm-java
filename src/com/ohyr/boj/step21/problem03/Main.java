package com.ohyr.boj.step21.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> buffer = new LinkedList<>();
		
		int n = Integer.parseInt(in.readLine());
		
		while(true) {
			int p = Integer.parseInt(in.readLine());
			
			if(p == -1) {
				break;
			}
			
			if(p == 0) {
				buffer.poll();
				continue;
			}
			
			if(buffer.size() < n) {
				buffer.offer(p);
			}
		}
		
		if(buffer.isEmpty()) {
			System.out.println("empty");
			return;
		}
		
		while(!buffer.isEmpty()) {
			sb.append(buffer.poll()).append(" ");
		}
		System.out.println(sb.toString());
	}

}
