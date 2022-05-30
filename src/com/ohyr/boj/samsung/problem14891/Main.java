package com.ohyr.boj.samsung.problem14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] magnet = new int[4][8];
		
		for(int i=0;i<4;i++) {
			char[] rL = in.readLine().toCharArray();
			for(int j=0;j<8;j++) {
				magnet[i][j] = rL[j] - '0';
			}
		}

		int k = Integer.parseInt(in.readLine());
		
		int redArrowIdx1 = 0;
		int redArrowIdx2 = 0;
		int redArrowIdx3 = 0;
		int redArrowIdx4 = 0;
		
		int answer = 0;

		// 0 = N / 1 = S
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(in.readLine());
			int target = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {target, dir});
			
			boolean visited[] = new boolean[4];
			
			while(!q.isEmpty()) {
				int t = q.peek()[0];
				int d = q.peek()[1];
				q.poll();
				
				if(visited[t-1]) continue;
				visited[t-1] = true;
				
				if(t == 1) {
					if(magnet[0][(redArrowIdx1+2)%8] != magnet[1][(redArrowIdx2+6)%8]) {
						q.offer(new int[] {2, -d});
					}
					redArrowIdx1 = (redArrowIdx1+8-d)%8;
				}else if(t == 2) {
					if(magnet[1][(redArrowIdx2+6)%8] != magnet[0][(redArrowIdx1+2)%8]) {
						q.offer(new int[] {1, -d});
					}
					if(magnet[1][(redArrowIdx2+2)%8] != magnet[2][(redArrowIdx3+6)%8]) {
						q.offer(new int[] {3, -d});
					}
					redArrowIdx2 = (redArrowIdx2+8-d)%8;
				}else if(t == 3) {
					if(magnet[2][(redArrowIdx3+6)%8] != magnet[1][(redArrowIdx2+2)%8]) {
						q.offer(new int[] {2, -d});
					}
					if(magnet[2][(redArrowIdx3+2)%8] != magnet[3][(redArrowIdx4+6)%8]) {
						q.offer(new int[] {4, -d});
					}
					redArrowIdx3 = (redArrowIdx3+8-d)%8;
				}else if(t == 4) {
					if(magnet[3][(redArrowIdx4+6)%8] != magnet[2][(redArrowIdx3+2)%8]) {
						q.offer(new int[] {3, -d});
					}
					redArrowIdx4 = (redArrowIdx4+8-d)%8;
				}
			}
		}
		if(magnet[0][redArrowIdx1] == 1) {
			answer += 1;
		}
		if(magnet[1][redArrowIdx2] == 1) {
			answer += 2;
		}
		if(magnet[2][redArrowIdx3] == 1) {
			answer += 4;
		}
		if(magnet[3][redArrowIdx4] == 1) {
			answer += 8;
		}
		
		System.out.println(answer);
	}

}
