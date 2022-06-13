package com.ohyr.boj.samsung.problem17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[] airCleanerRows = new int[2];
		int airCleanerIdx = 0;
		
		int[][] room = new int[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<c;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) airCleanerRows[airCleanerIdx++] = i;
			}
		}
		
		while(t-- > 0) {
			// 미세먼지가 확산된다.
			room = spreadDust(r, c, room);
			
			// 공기청정기가 작동한다.
			cleanAir(r, c, room, airCleanerRows);
		}
		
		int answer = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(room[i][j] > 0) {
					answer += room[i][j];
				}
			}
		}
		System.out.println(answer);
	}

	private static void cleanAir(int r, int c, int[][] room, int[] airCleanerRows) {
		cleanCounterClockwise(r, c, room, airCleanerRows[0]);
		cleanClockwise(r, c, room, airCleanerRows[1]);
	}

	private static void cleanCounterClockwise(int r, int c, int[][] room, int airCleanerRow) {
		int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
		int d = 0;
		int x = airCleanerRow;
		int y = 0;
		
		while(d < 4) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			if(nx < 0 || airCleanerRow < nx || ny < 0 || c <= ny) {
				d++;
				continue;
			}
			if(room[nx][ny] == -1) {
				room[x][y] = 0;
				break;
			}
			
			if(room[x][y] != -1) {
				room[x][y] = room[nx][ny];
			}
			
			x = nx;
			y = ny;
		}
	}

	private static void cleanClockwise(int r, int c, int[][] room, int airCleanerRow) {
		int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
		int d = 0;
		int x = airCleanerRow;
		int y = 0;
		
		while(d < 4) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			if(nx < airCleanerRow || r <= nx || ny < 0 || c <= ny) {
				d++;
				continue;
			}
			if(room[nx][ny] == -1) {
				room[x][y] = 0;
				break;
			}
			
			if(room[x][y] != -1) {
				room[x][y] = room[nx][ny];
			}
			
			x = nx;
			y = ny;
		}
	}

	private static int[][] spreadDust(int r, int c, int[][] room) {
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		
		int[][] tmp = new int[r][c];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(room[i][j] == -1) tmp[i][j] = -1;
				if(room[i][j] <= 0) continue;
				
				// 확산 가능한 방향의 개수 확인
				int spreadable = 0;
				for(int d=0;d<4;d++) {
					int x = i + deltas[d][0];
					int y = j + deltas[d][1];
					
					if(x < 0 || r <= x || y < 0 || c <= y) continue;
					if(room[x][y] == -1) continue;
					
					spreadable++;
				}
				
				// 확산되는 양
				int spreadAmount = room[i][j] / 5;
				// 남은 미세먼지 양
				tmp[i][j] += room[i][j] - (spreadAmount * spreadable);
				
				// 확산되는 양 인접한 방향에 추가
				for(int d=0;d<4;d++) {
					int x = i + deltas[d][0];
					int y = j + deltas[d][1];
					
					if(x < 0 || r <= x || y < 0 || c <= y) continue;
					if(room[x][y] == -1) continue;
					
					tmp[x][y] += spreadAmount;
				}
			}
		}
		
		return tmp;
	}

}
