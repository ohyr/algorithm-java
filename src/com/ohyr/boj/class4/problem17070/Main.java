package com.ohyr.boj.class4.problem17070;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 1, 0});
		
		int answer = 0;
		
		if(map[n-1][n-1] == 1) {
			System.out.println(answer);
			return;
		}
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int dir = q.peek()[2];
			q.poll();
			
			if(n <= x || n <= y) {
				continue;
			}
			
			if(map[x][y] == 1) {
				continue;
			}
			
			if(dir == 2 && (map[x-1][y] == 1 || map[x][y-1] == 1)) {
				continue;
			}
			
			if(x == n-1 && y == n-1) {
				answer++;
				continue;
			}
			
			if(dir != 0) {
				q.offer(new int[] {x+1, y, 1});
			}
			if(dir != 1) {
				q.offer(new int[] {x, y+1, 0});
			}
			q.offer(new int[] {x+1, y+1, 2});
		}
		
		System.out.println(answer);
	}

}
