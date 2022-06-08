package com.ohyr.boj.class4.problem16953;

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
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		Queue<long[]> q = new LinkedList<>();
		q.offer(new long[] {0, a});
		
		long answer = -1;
		
		while(!q.isEmpty()) {
			long cnt = q.peek()[0];
			long cur = q.peek()[1];
			q.poll();
			
			if(cur == b) {
				answer = cnt + 1;
				break;
			}
			
			if(cur > b) {
				continue;
			}
			
			q.offer(new long[] {cnt + 1, cur * 2});
			q.offer(new long[] {cnt + 1, cur * 10 + 1});
		}
		
		System.out.println(answer);
	}

}
