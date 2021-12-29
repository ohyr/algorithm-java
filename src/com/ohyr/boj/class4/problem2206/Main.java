package com.ohyr.boj.class4.problem2206;

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
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			char[] rL = in.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j] = rL[j] - '0';
			}
		}
		
		int answer = -1;
		
		class Me {
			int x;
			int y;
			int cnt;
			int crash;
			Me(int x, int y, int cnt, int crash){
				this.x = x;
				this.y = y;
				this.cnt = cnt;
				this.crash = crash;
			}
		}
		
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		
		Queue<Me> q = new LinkedList<>();
		q.offer(new Me(0, 0, 1, 0));
		
		boolean[][][] visited = new boolean[n][m][2];
		
		while(!q.isEmpty()) {
			Me me = q.poll();
			int x = me.x;
			int y = me.y;
			int cnt = me.cnt;
			int crash = me.crash;
			
			if(x == n-1 && y == m-1) {
				answer = cnt;
				break;
			}
			
			if(x < 0 || n <= x || y < 0 || m <= y) continue;
			if(visited[x][y][crash]) continue;
			visited[x][y][crash] = true;
			
			if(map[x][y] == 0) {
				for(int d=0;d<4;d++) {
					q.offer(new Me(x+deltas[d][0], y+deltas[d][1], cnt+1, crash));
				}
			}else {
				if(crash == 1) continue;
				
				crash = 1;
				
				for(int d=0;d<4;d++) {
					q.offer(new Me(x+deltas[d][0], y+deltas[d][1], cnt+1, crash));
				}
			}
		}
		
		System.out.println(answer);
	}

}
