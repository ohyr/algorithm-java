package com.ohyr.boj.class5.problem13460;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static int MoveCnt;
	public static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[n][m];
		
		for(int i=0;i<n;i++) {
			board[i] = in.readLine().toCharArray();
		}
		
		int answer = -1;
		
		class Game{
			char[][] prev;
			int gameCnt;
			Game(char[][] prev, int gameCnt){
				this.prev = prev;
				this.gameCnt = gameCnt;
			}
		}
		
		ArrayDeque<Game> q = new ArrayDeque<>();
		q.offer(new Game(board, 1));
		
		escape: while(!q.isEmpty()) {
			char[][] prev = q.peek().prev;
			int gameCnt = q.peek().gameCnt;
			q.poll();
			
			if(gameCnt == 11) {
				break;
			}
			
			int rx = 0;
			int ry = 0;
			int bx = 0;
			int by = 0;
			
			char[][] tmp = new char[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(prev[i][j] == 'R') {
						rx = i;
						ry = j;
						tmp[i][j] = '.';
					}else if(prev[i][j] == 'B') {
						bx = i;
						by = j;
						tmp[i][j] = '.';
					}else {
						tmp[i][j] = prev[i][j];
					}
				}
			}
			
			for(int d=0;d<4;d++) {
				MoveCnt = 0;
				
				char[][] cur = new char[n][m];
				for(int i=0;i<n;i++) {
					cur[i] = tmp[i].clone();
				}
				
				boolean finRed = false;
				boolean finBlue = false;
				
				if(d == 0) {
					if(ry < by) {
						finBlue = checkBlue(bx, by, cur, d);
						finRed = checkRed(rx, ry, cur, d);
					}else {
						finRed = checkRed(rx, ry, cur, d);
						finBlue = checkBlue(bx, by, cur, d);
					}
				}else if(d == 1) {
					if(rx < bx) {
						finBlue = checkBlue(bx, by, cur, d);
						finRed = checkRed(rx, ry, cur, d);
					}else {
						finRed = checkRed(rx, ry, cur, d);
						finBlue = checkBlue(bx, by, cur, d);
					}
				}else if(d == 2) {
					if(ry < by) {
						finRed = checkRed(rx, ry, cur, d);
						finBlue = checkBlue(bx, by, cur, d);
					}else {
						finBlue = checkBlue(bx, by, cur, d);
						finRed = checkRed(rx, ry, cur, d);
					}
				}else if(d == 3) {
					if(rx < bx) {
						finRed = checkRed(rx, ry, cur, d);
						finBlue = checkBlue(bx, by, cur, d);
					}else {
						finBlue = checkBlue(bx, by, cur, d);
						finRed = checkRed(rx, ry, cur, d);
					}
				}
				
				if(finBlue) continue;
				
				if(finRed == true && finBlue == false) {
					answer = gameCnt;
					break escape;
				}
				
				if(MoveCnt == 0) continue;
				
				q.offer(new Game(cur, gameCnt+1));
			}
		}
		
		System.out.println(answer);
	}

	private static boolean checkRed(int rx, int ry, char[][] cur, int d) {
		boolean finRed = false;
		
		while(true) {
			int nx = rx + deltas[d][0];
			int ny = ry + deltas[d][1];
			
			if(cur[nx][ny] == '#' || cur[nx][ny] == 'B') {
				cur[rx][ry] = 'R';
				break;
			}
			
			if(cur[nx][ny] == 'O') {
				finRed = true;
				break;
			}
			
			rx = nx;
			ry = ny;
			
			MoveCnt++;
		}
		
		return finRed;
	}

	private static boolean checkBlue(int bx, int by, char[][] cur, int d) {
		boolean finBlue = false;
		
		while(true) {
			int nx = bx + deltas[d][0];
			int ny = by + deltas[d][1];
			
			if(cur[nx][ny] == '#' || cur[nx][ny] == 'R') {
				cur[bx][by] = 'B';
				break;
			}
			
			if(cur[nx][ny] == 'O') {
				finBlue = true;
				break;
			}
			
			bx = nx;
			by = ny;
			
			MoveCnt++;
		}
		
		return finBlue;
	}
}
