package com.ohyr.boj.step24.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int answer = 1;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++) {
			int w = Integer.parseInt(st.nextToken());
			int c = pq.poll();
			
			if(w > c) {
				answer = 0;
				break;
			}
			
			pq.offer(c - w);
		}
		
		System.out.println(answer);
	}

}
