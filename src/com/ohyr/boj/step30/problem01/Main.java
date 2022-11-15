package com.ohyr.boj.step30.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		
		Queue<X> q = new LinkedList<>();
		List<Integer> initLog = new LinkedList<>();
		initLog.add(n);
		q.offer(new X(0, n, initLog));
		
		boolean[] visited = new boolean[n+1];
		
		while(!q.isEmpty()) {
			int cnt = q.peek().cnt;
			int x = q.peek().x;
			List<Integer> log = q.peek().log;
			q.poll();
			
			if(x == 1) {
				sb.append(cnt).append("\n");
				for(int l : log) {
					sb.append(l).append(" ");
				}
				break;
			}
			
			if(x < 1) continue;
			if(visited[x]) continue;
			visited[x] = true;
			
			
			
			if(x % 3 == 0) {
				List<Integer> tmp1 = new LinkedList<>();
				for(int l : log) {
					tmp1.add(l);
				}
				tmp1.add(x/3);
				q.offer(new X(cnt+1, x/3, tmp1));
			}
			
			if(x % 2 == 0) {
				List<Integer> tmp2 = new LinkedList<>();
				for(int l : log) {
					tmp2.add(l);
				}
				tmp2.add(x/2);
				q.offer(new X(cnt+1, x/2, tmp2));
			}
			
			List<Integer> tmp3 = new LinkedList<>();
			for(int l : log) {
				tmp3.add(l);
			}
			tmp3.add(x - 1);
			q.offer(new X(cnt+1, x-1, tmp3));
		}
		
		System.out.println(sb.toString());
	}
	
	public static class X {
		int cnt;
		int x;
		List<Integer> log;
		X(int cnt, int x, List<Integer> log) {
			this.cnt = cnt;
			this.x = x;
			this.log = log;
		}
	}

}
