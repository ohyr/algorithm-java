package com.ohyr.boj.class4.problem2638;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cheezeSize = 0;
		int[][] area = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] == 1) cheezeSize++;
			}
		}
		
		int answer = 0;
		
		int[][] tmp = new int[n][m];
		
		while(cheezeSize > 0) {
			for(int i=0;i<n;i++) {
				tmp[i] = area[i].clone();
			}
			
			// check air to 9
			checkAirArea(0, 0, tmp);
			
			for(int i=1;i<n-1;i++) {
				for(int j=1;j<m-1;j++) {
					if(area[i][j] != 1) continue;
					if(isMelted(i, j, tmp)) {
						area[i][j] = 0;
						cheezeSize--;
					}
				}
			}
			
			answer++;
		}
		
		System.out.println(answer);
	}

	private static boolean isMelted(int x, int y, int[][] area) {
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		
		int airCnt = 0;
		
		for(int d=0;d<4;d++) {
			if(area[x+deltas[d][0]][y+deltas[d][1]] == 9) {
				airCnt++;
			}
			
			if(airCnt > 1) return true;
		}
		
		return false;
	}

	private static void checkAirArea(int x, int y, int[][] area) {
		if(x < 0 || area.length <= x || y < 0 || area[0].length <= y) return;
		if(area[x][y] != 0) return;
		
		area[x][y] = 9;
		
		checkAirArea(x, y+1, area);
		checkAirArea(x+1, y, area);
		checkAirArea(x, y-1, area);
		checkAirArea(x-1, y, area);
	}

}
