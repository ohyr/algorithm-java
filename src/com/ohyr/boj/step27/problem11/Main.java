package com.ohyr.boj.step27.problem11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static final int[][] deltas = { 
		{1, 2}, {-1, 2}, {1, -2}, {-1, -2},
		{2, 1}, {-2, 1}, {2, -1}, {-2, -1}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
						
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { 0, x1, y1 });
			
			boolean[][] visited = new boolean[n][n];
			visited[x1][y1] = true;
			
			int answer = 0;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int cnt = cur[0];
				int x = cur[1];
				int y = cur[2];
				
				if(x == x2 && y == y2) {
					answer = cnt;
					break;
				}
				
				for(int d=0;d<8;d++) {
					int nX = x + deltas[d][0];
					int nY = y + deltas[d][1];
					
					if(nX < 0 || n <= nX || nY < 0 || n <= nY) {
						continue;
					}

					if(visited[nX][nY]) {
						continue;
					}
					visited[nX][nY] = true;
					
					q.offer(new int[] { cnt + 1, nX, nY });
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
