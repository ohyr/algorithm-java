package com.ohyr.boj.samsung.problem3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		// 벽: 9, 사과: 7, 뱀: 1
		
		// 벽 세우기
		int[][] board = new int[n+2][n+2];
		for(int i=0;i<n+2;i++) {
			board[i][0] = 9;
			board[i][n+1] = 9;
			board[0][i] = 9;
			board[n+1][i] = 9;
		}
		
		// 사과 놓기
		int k = Integer.parseInt(in.readLine());
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x][y] = 7;
		}
		
		int answer = 0; // 몇 초에 끝나는 지 (출력 값)
		
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		
		// 뱀의 초기 방향 (오른쪽)
		int d = 0;
		
		// 뱀의 초기 위치 (맨위 맨좌측)
		board[1][1] = 1;
		
		// 뱀의 좌표들 저장
		ArrayDeque<int[]> snake = new ArrayDeque<>();
		snake.offer(new int[] {1, 1});
		
		// 뱀 이동
		int l = Integer.parseInt(in.readLine());
		for(int t=0;t<=l;t++) {
			int sec = 10001;
			String dir = "S";
			
			if(t != l) {
				st = new StringTokenizer(in.readLine());
				sec = Integer.parseInt(st.nextToken());
				dir = st.nextToken();
			}
			
			// move
			boolean isEnd = false;
			while(answer < sec) {
				answer++;
				
				int x = snake.peekFirst()[0] + deltas[d][0];
				int y = snake.peekFirst()[1] + deltas[d][1];
				
				if(board[x][y] == 9 || board[x][y] == 1) {
					isEnd = true;
					break;
				}
				
				if(board[x][y] == 7) {
					board[x][y] = 1;
					snake.offerFirst(new int[] {x, y});
				}else {
					board[x][y] = 1;
					snake.offerFirst(new int[] {x, y});
					board[snake.peekLast()[0]][snake.peekLast()[1]] = 0;
					snake.pollLast();
				}
			}
			if(isEnd) break;
			
			// 방향 전환
			if(dir.equals("L")) {
				d = (d+3)%4;
			}else if(dir.equals("D")) {
				d = (d+1)%4;
			}
		}
		
		System.out.println(answer);
	}

}
