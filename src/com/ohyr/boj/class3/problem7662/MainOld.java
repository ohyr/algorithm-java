package com.ohyr.boj.class3.problem7662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MainOld {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int k = Integer.parseInt(in.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
			
			int size = 0;
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(in.readLine());
				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				
				switch(command) {
				case "I":
					pq.offer(value);
					rpq.offer(value);
					size++;
					break;
				case "D":
					if(size == 0) continue;
					
					if(value == 1) {
						rpq.poll();
					}else if(value == -1){
						pq.poll();
					}
					
					size--;
					if(size == 0) {
						while(!pq.isEmpty()) pq.poll();
						while(!rpq.isEmpty()) rpq.poll();
					}
					break;
				}
			}
			
			if(size == 0) {
				sb.append("EMPTY");
			}else {
				sb.append(rpq.poll()).append(" ").append(pq.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
