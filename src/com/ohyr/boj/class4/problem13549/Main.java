package com.ohyr.boj.class4.problem13549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int nkLimit = n > k ? (2 * n) : (2 * k);
		
		int[] checked = new int[nkLimit];
		Arrays.fill(checked, Integer.MAX_VALUE);
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, n});
		
		int answer = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int cnt = q.peek()[0];
			int cur = q.peek()[1];
			q.poll();
			
			if(cur < 0 || nkLimit <= cur) continue;
			if(cur == k) {
				answer = Math.min(answer, cnt);
				continue;
			}
			
			if(checked[cur] <= cnt) continue;
			checked[cur] = cnt;
			
			q.offer(new int[] {cnt + 1, cur + 1});
			q.offer(new int[] {cnt + 1, cur - 1});
			if(cur < k) {				
				q.offer(new int[] {cnt, 2 * cur});
			}
		}
		
		System.out.println(answer);
	}

}
