package com.ohyr.boj.step26.problem09;

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
		
		int[][] maze = new int[n][m];
		
		for(int i=0;i<n;i++) {
			char[] rL = in.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				maze[i][j] = rL[j]-'0';
			}
		}
		
		int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};

		int[][] visited = new int[n][m];
		
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> qc = new LinkedList<>();
		
		qx.add(0);
		qy.add(0);
		qc.add(1);
		int answer = 0;
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			int cnt = qc.poll();

			if(x < 0 || n <= x || y < 0 || m <= y) continue;
			if(maze[x][y] == 0) continue;
			if(visited[x][y] == 1) continue;
			visited[x][y] = 1;
			if(x == n-1 && y == m-1) {
				answer = cnt;
				break;
			}
			
			for(int d=0;d<4;d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				qx.add(nx);
				qy.add(ny);
				qc.add(cnt+1);
			}
		}
		
		System.out.println(answer);
	}

}
