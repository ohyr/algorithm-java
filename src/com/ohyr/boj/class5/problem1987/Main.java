package com.ohyr.boj.class5.problem1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[r][c];
		for(int i=0;i<r;i++) {
			board[i] = in.readLine().toCharArray();
		}
		
		Answer = 0;
		dfs(0, 0, 0, 1, r, c, board);
		
		System.out.println(Answer);
	}

	private static void dfs(int x, int y, int flag, int cnt, int r, int c, char[][] board) {
		
		if(x < 0 || r <= x || y < 0 || c <= y) return;
		if((flag & 1 << board[x][y] - 'A') != 0) return;
		
		flag = flag | 1 << board[x][y] - 'A';
		
		Answer = Math.max(Answer, cnt);
		
		dfs(x-1, y, flag, cnt+1, r, c, board);
		dfs(x, y-1, flag, cnt+1, r, c, board);
		dfs(x+1, y, flag, cnt+1, r, c, board);
		dfs(x, y+1, flag, cnt+1, r, c, board);
	}
}
