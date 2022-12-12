package com.ohyr.boj.step24.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(in.readLine());
			if(minHeap.size() == maxHeap.size()) {
				if(!minHeap.isEmpty() && x > minHeap.peek()) {
					maxHeap.add(minHeap.poll());
					minHeap.add(x);
				}else {					
					maxHeap.add(x);
				}
			}else {
				if(!maxHeap.isEmpty() && x < maxHeap.peek()) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(x);
				}else {					
					minHeap.add(x);
				}
			}
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}

}
