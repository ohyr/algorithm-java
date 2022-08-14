package com.ohyr.boj.class5.problem1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.offer(new int[] {a, b, c});
		}
		
		int answer = 0;
		
		int[] p = new int[v+1];
		for(int i=1;i<=v;i++) {
			p[i] = i;
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int a = cur[0];
			int b = cur[1];
			int c = cur[2];
			
			int pa = findParent(a, p);
			int pb = findParent(b, p);
			
			if(pa == pb) {
				continue;
			}
			
			p[pa] = Math.min(pa, pb);
			p[pb] = Math.min(pa, pb);
			
			answer += c;
		}
		
		System.out.println(answer);
	}

	public static int findParent(int x, int[] p) {
		if(p[x] == x) {
			return x;
		}
		return p[x] = findParent(p[x], p);
	}
}
