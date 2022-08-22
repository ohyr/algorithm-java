package com.ohyr.boj.class5.problem2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> stu = new ArrayList<>();
		for(int i=0;i<=n;i++) {
			stu.add(new ArrayList<>());
		}
		
		int[] linked = new int[n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			stu.get(a).add(b);
			linked[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(linked[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			sb.append(cur).append(" ");
			
			List<Integer> list = stu.get(cur);
			for(int i=0;i<list.size();i++) {
				int l = list.get(i);
				if(--linked[l] == 0) {
					q.offer(l);
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
