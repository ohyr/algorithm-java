package com.ohyr.boj.step27.problem14;

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
		
		int[] board = new int[101]; 
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x] = y;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			board[u] = v;
		}
		
		class Dice{
			int cur;
			int cnt;
			Dice(int cur, int cnt){
				this.cur = cur;
				this.cnt = cnt;
			}
		}
		
		Queue<Dice> q = new LinkedList<>();
		q.offer(new Dice(1, 0));
		
		int answer = 0;
		
		while(!q.isEmpty()) {
			Dice dice = q.poll();
			int cur = dice.cur;
			int cnt = dice.cnt;
			
			// 이미 방문했으면
			if(board[cur] == -1) continue;
			
			// 사다리나 뱀이 있는 칸이면 cur값 이동
			if(board[cur] != 0) {
				cur = board[cur];
			}
			
			if(cur > 100) continue;
			if(cur == 100) {
				answer = cnt;
				break;
			}
			
			// 이미 방문했던 곳 표시해서 안가게
			// 반복 작업 제거
			board[cur] = -1;
			
			for(int i=1;i<=6;i++) {
				q.offer(new Dice(cur+i, cnt+1));
			}
		}
		
		System.out.println(answer);
	}

}
