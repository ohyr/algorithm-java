package com.ohyr.boj.step24.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			int k = Integer.parseInt(in.readLine());
			if(k == 0) {
				if(pq.isEmpty()) System.out.println("0");
				else System.out.println(pq.poll());
			}else {
				pq.add(k);
			}
		}		
	}

}
