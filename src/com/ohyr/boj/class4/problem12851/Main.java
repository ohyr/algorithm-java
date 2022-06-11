package com.ohyr.boj.class4.problem12851;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int nkLimit = n > k ? n : 2 * k;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, n});
		
		int[] visited = new int[nkLimit + 1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		int time = Integer.MAX_VALUE;
		int answer = 0;
		
		while(!q.isEmpty()) {
			int cnt = q.peek()[0];
			int cur = q.peek()[1];
			q.poll();
			
			if(cnt > time) {
				continue;
			}
			
			if(cur < 0 || nkLimit < cur) {
				continue;
			}
			
			if(cur == k) {
				if(time > cnt) {
					time = cnt;
					answer = 1;
				}else if(time == cnt) {
					answer++;
				}
				continue;
			}
			
			if(visited[cur] < cnt) {
				continue;
			}
			visited[cur] = cnt;
			
			q.offer(new int[] {cnt + 1, cur + 1});
			q.offer(new int[] {cnt + 1, cur - 1});
			q.offer(new int[] {cnt + 1, 2 * cur});				
		}
		
		sb.append(time).append("\n").append(answer);
		System.out.println(sb.toString());
	}

}
