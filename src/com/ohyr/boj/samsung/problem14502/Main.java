package com.ohyr.boj.samsung.problem14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] area = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 벽 세우기 (모든 벽 세우기 조합 확인)
		Answer = 0;
		buildWall(0,0,n,m,area);
		
		System.out.println(Answer);
	}

	private static void buildWall(int cnt, int start, int n, int m, int[][] area) {
		if(cnt == 3) {
			// 벽 3개가 세워졌으면
			int[][] tmpArea = new int[n][m];
			for(int i=0;i<n;i++) {
				tmpArea[i] = area[i].clone();
			}
			
			// 바이러스 퍼뜨리기
			spreadVirus(n, m, tmpArea);
			return;
		}
		
		for(int i=start;i<n*m;i++) {
			int x = i/m;
			int y = i%m;
		
			if(area[x][y] != 0) continue;
			
			area[x][y] = 1;
			buildWall(cnt+1, i+1, n, m, area);
			area[x][y] = 0;
		}
	}

	private static void spreadVirus(int n, int m, int[][] area) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(area[i][j] != 2) continue;
				// 바이러스가 있는 곳이면 dfs로 해당 area 좌표 2로 채워주기
				area[i][j] = 0;
				dfs(i, j, n, m, area);
			}
		}
		
		// 안전지대 개수 세보기
		int safeZoneSize = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(area[i][j] == 0) {
					safeZoneSize++;
				}
			}
		}
		// 최대값 갱신
		Answer = Math.max(Answer, safeZoneSize);
	}

	private static void dfs(int x, int y, int n, int m, int[][] area) {
		if(x < 0 || n <= x || y < 0 || m <= y) return;
		if(area[x][y] != 0) return;
		
		area[x][y] = 2;
		
		dfs(x, y+1, n, m, area);
		dfs(x+1, y, n, m, area);
		dfs(x, y-1, n, m, area);
		dfs(x-1, y, n, m, area);
	}

}
