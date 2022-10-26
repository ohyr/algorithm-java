package com.ohyr.boj.step21.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			if(cnt%k == 0) {
				cnt = 0;
				sb.append(q.poll()).append(", ");
			}else {
				q.offer(q.poll());
			}
		}
		
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());
	}

}
