package com.ohyr.boj.step26.problem10;

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
		int k = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		boolean[] visited = new boolean[100001];
		
		Queue<Subin> q = new LinkedList<>();
		q.offer(new Subin(n, 0));
		
		while(!q.isEmpty()) {
			Subin subin = q.poll();
			if(subin.pos == k) {
				answer = subin.sec;
				break;
			}
			if(subin.pos < 0 || 100000 < subin.pos) continue;
			if(visited[subin.pos]) continue;
			visited[subin.pos] = true;
			
			q.offer(new Subin(subin.pos*2, subin.sec+1));
			q.offer(new Subin(subin.pos-1, subin.sec+1));
			q.offer(new Subin(subin.pos+1, subin.sec+1));
		}
		
		System.out.println(answer);
	}
	
	public static class Subin {
		int pos;
		int sec;
		
		Subin(int pos, int sec){
			this.pos = pos;
			this.sec = sec;
		}
	}

}
