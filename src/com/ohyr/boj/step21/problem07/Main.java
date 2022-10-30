package com.ohyr.boj.step21.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		
		int answer = 0;
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++) {
			int cur = Integer.parseInt(st.nextToken());
			int cnt = 0;
			while(q.peek() != cur) {
				q.offer(q.poll());
				cnt++;
			}
			answer += Math.min(cnt, n - cnt);
			q.poll();
			n--;
		}
		
		System.out.println(answer);
	}

}
