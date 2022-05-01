package com.ohyr.boj.samsung.problem21608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] room = new int[n+1][n+1];
		boolean[][] stuLiked = new boolean[n*n+1][n*n+1];
		
		for(int i=0;i<n*n;i++) {
			st = new StringTokenizer(in.readLine());
			int stu = Integer.parseInt(st.nextToken());
			boolean[] liked = new boolean[n*n+1];
			for(int j=0;j<4;j++) {
				int like = Integer.parseInt(st.nextToken());
				liked[like] = true;
			}
			
			stuLiked[stu] = liked.clone();
			
			goSeat(n, room, stu, liked);
		}
		
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		int answer = 0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int like = 0;
				for(int d=0;d<4;d++) {
					int x = i + deltas[d][0];
					int y = j + deltas[d][1];
					
					if(x < 1 || n < x || y < 1 || n < y) continue;
					if(stuLiked[room[i][j]][room[x][y]]) like++; 
				}
				if(like == 1) {
					answer += 1;
				}else if(like == 2) {
					answer += 10;
				}else if(like == 3) {
					answer += 100;
				}else if(like == 4){
					answer += 1000;
				}
			}
		}
		
		System.out.println(answer);
	}

	private static void goSeat(int n, int[][] room, int stu, boolean[] liked) {
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		
		List<int[]> posList = new ArrayList<>();
		int max = 0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(room[i][j] != 0) continue;
				int likeNum = 0;
				for(int d=0;d<4;d++) {
					int x = i + deltas[d][0];
					int y = j + deltas[d][1];
					
					if(x < 1 || n < x || y < 1 || n < y) continue;
					if(liked[room[x][y]]) likeNum++;
					
				}
				if(likeNum > max) {
					max = likeNum;
					posList.clear();
					posList.add(new int[] {i, j});
				}else if(likeNum == max) {
					posList.add(new int[] {i, j});
				}
			}
		}
		
		if(posList.size() == 1) {
			room[posList.get(0)[0]][posList.get(0)[1]] = stu;
		}else if(posList.size() == 0) {
			int maxEm = 0;
			int maxX = 0;
			int maxY = 0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					int emNum = 0;
					for(int d=0;d<4;d++) {
						int x = i + deltas[d][0];
						int y = j + deltas[d][1];
						
						if(x < 1 || n < x || y < 1 || n < y) continue;
						if(room[x][y] == 0) emNum++;
					}
					if(emNum > maxEm) {
						maxEm = emNum;
						maxX = i;
						maxY = j;
					}
				}
			}
			room[maxX][maxY] = stu;
		}else {
			int maxEm = 0;
			int maxX = posList.get(0)[0];
			int maxY = posList.get(0)[1];
			for(int[] pos: posList) {
				int emNum = 0;
				for(int d=0;d<4;d++) {
					int x = pos[0] + deltas[d][0];
					int y = pos[1] + deltas[d][1];
					
					if(x < 1 || n < x || y < 1 || n < y) continue;
					if(room[x][y] == 0) emNum++;
				}
				if(emNum > maxEm) {
					maxEm = emNum;
					maxX = pos[0];
					maxY = pos[1];
				}
			}
			room[maxX][maxY] = stu;
		}
	}

}
