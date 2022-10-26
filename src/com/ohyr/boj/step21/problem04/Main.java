package com.ohyr.boj.step21.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
			Queue<int[]> q = new LinkedList<>();
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++) {
				int pr = Integer.parseInt(st.nextToken());
				q.offer(new int[] {pr, i});
				pq.offer(pr);
			}
			
			int cnt = 1;
			while(!q.isEmpty()) {
				if(q.peek()[0] == pq.peek()) {
					if(q.peek()[1] == m) {
						sb.append(cnt).append("\n");
						break;
					}
					q.poll();
					pq.poll();
					cnt++;
				}else {
					q.offer(q.poll());
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
