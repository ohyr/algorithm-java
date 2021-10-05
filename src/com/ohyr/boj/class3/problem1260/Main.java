package com.ohyr.boj.class3.problem1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] Map;
	
	static void dfs(int n, int v) {
		System.out.print(v + " ");
		
		for(int i=1;i<=n;i++) {
			if(Map[v][i] == 1 && Map[i][i] != 1) {
				Map[i][i] = 1;
				dfs(n, i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		int[][] mapDFS = new int[n+1][n+1];
		int[][] mapBFS = new int[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			mapDFS[x][y] = 1;
			mapDFS[y][x] = 1;
			mapBFS[x][y] = 1;
			mapBFS[y][x] = 1;
		}
		sc.close();
		
		Map = mapDFS;
		Map[v][v] = 1;
		dfs(n, v);

		System.out.println();
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		mapBFS[v][v] = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for(int i=1;i<=n;i++) {
				if(mapBFS[cur][i] == 1 && mapBFS[i][i] != 1) {
					mapBFS[i][i] = 1;
					q.offer(i);
				}
			}
		}
		
	}

}
