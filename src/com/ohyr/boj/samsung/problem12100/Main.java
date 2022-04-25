package com.ohyr.boj.samsung.problem12100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] board = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		class Game{
			int[][] game;
			int cnt;
			Game(int[][] game, int cnt){
				this.game = game;
				this.cnt = cnt;
			}
		}
		
		ArrayDeque<Game> q = new ArrayDeque<>();
		q.offer(new Game(board, 0));
		
		int answer = 0;
		
		while(!q.isEmpty()) {
			Game cur = q.poll();
			
			int max = 0;
			int[][] game = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					game[i][j] = cur.game[i][j];
					max = Math.max(max, game[i][j]);
				}
			}
			int cnt = cur.cnt;
			
			if(cnt == 6) {
				break;
			}
			answer = Math.max(answer, max);
			
			for(int d=0;d<4;d++) {
				int[][] tmp = move(n, game, d);
				
				q.offer(new Game(tmp, cnt+1));
			}
		}
		
		System.out.println(answer);
	}

	private static int[][] move(int n, int[][] game, int d) {
		int[][] rst = new int[n][n];
		
		if(d == 0) {
			for(int i=0;i<n;i++) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int j=n-1;j>=0;j--) {
					if(game[i][j] != 0) {
						list.add(game[i][j]);
					}
				}
				
				for(int j=0;j<list.size()-1;j++) {
					int a = list.get(j);
					int b = list.get(j+1);
					if(a == b) {
						list.set(j, a+b);
						list.remove(j+1);
					}
				}
				
				for(int j=0;j<list.size();j++) {
					rst[i][n-1-j] = list.get(j);
				}
			}
		}else if(d == 1) {
			for(int i=0;i<n;i++) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int j=n-1;j>=0;j--) {
					if(game[j][i] != 0) {
						list.add(game[j][i]);
					}
				}
				
				for(int j=0;j<list.size()-1;j++) {
					int a = list.get(j);
					int b = list.get(j+1);
					if(a == b) {
						list.set(j, a+b);
						list.remove(j+1);
					}
				}
				
				for(int j=0;j<list.size();j++) {
					rst[n-1-j][i] = list.get(j);
				}
			}
		}else if(d == 2) {
			for(int i=0;i<n;i++) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int j=0;j<n;j++) {
					if(game[i][j] != 0) {
						list.add(game[i][j]);
					}
				}
				
				for(int j=0;j<list.size()-1;j++) {
					int a = list.get(j);
					int b = list.get(j+1);
					if(a == b) {
						list.set(j, a+b);
						list.remove(j+1);
					}
				}
				
				for(int j=0;j<list.size();j++) {
					rst[i][j] = list.get(j);
				}
			}
		}else if(d == 3) {
			for(int i=0;i<n;i++) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int j=0;j<n;j++) {
					if(game[j][i] != 0) {
						list.add(game[j][i]);
					}
				}
				
				for(int j=0;j<list.size()-1;j++) {
					int a = list.get(j);
					int b = list.get(j+1);
					if(a == b) {
						list.set(j, a+b);
						list.remove(j+1);
					}
				}
				
				for(int j=0;j<list.size();j++) {
					rst[j][i] = list.get(j);
				}
			}
		}
		
		return rst;
	}

}
