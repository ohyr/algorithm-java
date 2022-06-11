package com.ohyr.boj.samsung.problem16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static boolean help(int size, int[][] sea) {
		for(int i=0;i<sea.length;i++) {
			for(int j=0;j<sea.length;j++) {
				if(sea[i][j] != 0 && sea[i][j] < size) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] sea = new int[n][n];
		
		class BabyShark {
			int x;
			int y;
			int size;
			int exp;
			int time;
			BabyShark(int x, int y, int size, int exp, int time) {
				this.x = x;
				this.y = y;
				this.size = size;
				this.exp = exp;
				this.time = time;
			}
		}
		
		BabyShark babyShark = new BabyShark(0, 0, 2, 0, 0);
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if(sea[i][j] == 9) {
					babyShark.x = i;
					babyShark.y = j;
					sea[i][j] = 0;
				}
			}
		}
		
		int answer = 0;
		
		Queue<BabyShark> q = new LinkedList<>();
		q.offer(babyShark);
		
		boolean[][] visited = new boolean[n][n];
		
		int[][] deltas = {{-1, 0},{0, -1},{0, 1},{1, 0}};
		
		BabyShark tmp = new BabyShark(n-1, n-1, 2, 0, 0);
		boolean isFind = false;
		
		while(!q.isEmpty()) {
			BabyShark cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int size = cur.size;
			int exp = cur.exp;
			int time = cur.time;
			
			// 다음 시간을 받았을 때 먹는다
			if(isFind && time > tmp.time) {
				sea[tmp.x][tmp.y] = 0;
				tmp.exp++;
				if(tmp.exp == tmp.size) {
					tmp.exp = 0;
					tmp.size++;
				}
				
				// 도움 요청해야 되는지?
				if(help(tmp.size, sea)) {
					break;
				}
				
				// 초기화
				while(!q.isEmpty()) {q.poll();}
				
				q.offer(new BabyShark(tmp.x, tmp.y, tmp.size, tmp.exp, tmp.time));
				visited = new boolean[n][n];
				tmp = new BabyShark(n-1, n-1, tmp.size, tmp.exp, tmp.time);
				isFind = false;
				
				continue;
			}
			
			if(x < 0 || n <= x || y < 0 || n <= y) continue;
			if(sea[x][y] > size) continue;
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			// 먹을 수 있는 걸 찾았을 때
			// tmp에 저장
			// 가장 위에, 왼쪽 물고기
			if(sea[x][y] != 0 && sea[x][y] < size) {
				if(tmp.x > x) {
					tmp.x = x;
					tmp.y = y;
					tmp.size = size;
					tmp.exp = exp;
					tmp.time = time;
					isFind = true;
				}else if(tmp.x == x && tmp.y >= y) {
					tmp.x = x;
					tmp.y = y;
					tmp.size = size;
					tmp.exp = exp;
					tmp.time = time;
					isFind = true;
				}
			}
			
			for(int d=0;d<4;d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				q.offer(new BabyShark(nx, ny, size, exp, time+1));
			}
		}
		
		answer = tmp.time;
		
		System.out.println(answer);
	}

}
